package com.zqx.hospitalmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.zqx.hospitalmanage.pojo.*;
import com.zqx.hospitalmanage.service.*;
import com.zqx.hospitalmanage.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.ToHtmlCotroller
 * @description: 跳转html页面
 * @author:
 * @create: 2019-03-19 11:06:03
 **/
@Controller
public class ToHtmlCotroller {

    @Autowired
    private MenuService menuService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private PatientService patientService;

    @Autowired
    private LogService logService;
    @Autowired
    private AdministrativeService administrativeService;
    @Autowired
    private DutyRosterService dutyRosterService;
    @Autowired
     private RegistrationService registrationService;
    @Autowired
    private ProblemService problemService;
    @Autowired
    private EvlauateService evlauateService;
    @Autowired
    private SolvePatientService solvePatientService;

    //全局变量调用
    String thetime="";
    String dname="";
    String keshi="";
    String did="";
    String newtime="";

    @RequestMapping("myindex1")
    public String index(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user==null){
            return "您还未登录，请登录";//===>页面
        }
        return "myindex.html";
    }

    @RequestMapping("getMenu")
    @ResponseBody
    public String getMenu(HttpSession session){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user==null){
            return "您还未登录，请登录";//===>页面
        }
        List<Role> role = user.getRole();
        Role role1 = role.get(0);
        List<Menu> all = menuService.findAll(role1.getId());
        Object o = JSONObject.toJSON(all);
        System.out.println(o.toString());
        return role1.getName();
    }

    @RequestMapping("myindex")
    public List<Menu> toMyIndex(HttpSession session, Model model){
        Doctor user = (Doctor) session.getAttribute("user");
        if(user==null){
            return null;//===>页面
        }
        List<Role> role = user.getRole();
        Role role1 = role.get(0);
        List<Menu> all = menuService.findAll(role1.getId());//menu
        model.addAttribute("menu",all);
        return all;
    }

    @RequestMapping("Doctor_management.html")
    public String  getAllDoctor(Model model,HttpSession session){
        model.addAttribute("list",doctorService.findAll());
        return "Doctor_management.html";
    }

    //默认查找所有病人信息
    @RequestMapping("Patient_management.html")
    public String  getAllpatient(Model model){
        List<Patient> list = patientService.findAllpatient();
        model.addAttribute("puser",list);
        return "/Patient_management.html";
    }

    //根据姓名查找病人
    @RequestMapping("select")
    public String selectPatientByName(String name,Model model){
        List<Patient> list1=patientService.selectPabyName(name);
        model.addAttribute("puser",list1);
        return "Patient_management.html";
    }

    //进入公告界面默认展示所有公告信息
    @RequestMapping("Announcement_management.html")
    public String  getAllannou(Model model){
        List<Announcement> list = announcementService.findAll();
        model.addAttribute("annou",list);
        return "Announcement_management.html";
    }

    //页面跳转
    @RequestMapping("{page}")
    public String toPage(@PathVariable("page") String page, HttpSession session){
        if(page.equals("index")||page.equals("index.html")||page.equals("keshi.html")||page.equals("keshimx.html")||page.equals("keshiys.html")||page.equals("notice.html")||page.equals("plogin.html")||page.equals("preg.html")||page.equals("news.html")||page.equals("404.html")){
            return page;
        }
        Object user = session.getAttribute("user");
        if(user==null){
            return "您还未登录，请登录";//===>页面
        }
        return page;
    }

    @RequestMapping("index")
    @ResponseBody
    public String cometoindex(HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser==null){
            return "<li><a href=\"plogin.html\">登录</a> </li><li><a href=\"preg.html\">注册</a> </li>";//===>页面
        }else {
            return "<li><a onclick=\"f()\">注销</a>\n</li>";
        }
    }
    @RequestMapping("welcome")
    @ResponseBody
    public String hunaying(HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser!=null){
            return "欢迎你"+puser.getName();
        }else {
            return "快捷菜单";
        }
    }

    //根据id查找公告
    @RequestMapping("findannoubyid")
    public String selectallannoubyid(Model model,String id){
        Announcement announcement=this.announcementService.findById(id);
        model.addAttribute("anuouview",announcement);
        return "/Announcementdetils.html";
    }

    //根据id查找病人和医生
    @RequestMapping("selPatientbyid")
    public String selectpatientById(String id,Model model){
        Patient patient=this.patientService.selepatient(id);
        model.addAttribute("pat",patient);
        return "/update_patient.html";
    }

    //根据主键查找医生
    @RequestMapping("doctorfindById")
    public String findOneById(String id, Model model){
        Doctor one = doctorService.findOneById(id);
        model.addAttribute("d",one);
        return "get_doctor.html";
    }


    /*查找所有日志记录*/
    @RequestMapping("log.html")
    public String findallLog(Model model){
     List<Log> list=  logService.findallLog();
     model.addAttribute("log",list);
        return "log.html";
    }
    //传入id查找医生信息
    @RequestMapping("ys.html")
    public String findDoctor(String id,Model model){
        Doctor doctor = doctorService.findOneById(id);
        List<DutyRoster> ds = dutyRosterService.findOneByDoctorId(id);
        List<Evlauate> list= evlauateService.findallbyid(id);
        model.addAttribute("myev",list);
        model.addAttribute("doctor",doctor);
        if(ds != null && ds.size() != 0) {
            model.addAttribute("ds", ds.get(0));
        }else{
            DutyRoster dy = new DutyRoster();
            dy.setId("");
            dy.setOperationTime(new Date());
            dy.setDay01(""); dy.setDay02(""); dy.setDay03(""); dy.setDay04(""); dy.setDay05(""); dy.setDay06("");
            dy.setDay07(""); dy.setDay08(""); dy.setDay09(""); dy.setDay10(""); dy.setDay11(""); dy.setDay12("");
            dy.setDay13(""); dy.setDay14("");
            model.addAttribute("ds",dy);
        }
        return "ys.html";
    }

    @RequestMapping("keshimx.html")
    public String seeAdministrative(String id, Model model){
        Administrative one = administrativeService.findOne(id);
        model.addAttribute("ad",one);
        return "keshimx.html";
    }

    //加载个人中心时展示所有想展示的数据
    @RequestMapping("geren.html")
    public String togeren(Patient patient, Model model,HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser==null){
            return "redirect:/plogin.html";//===>页面
        }
        String identification=puser.getIdentification();
        String password=puser.getPassword();
        String pid=puser.getId();
        patient.setIdentification(identification);
        patient.setPassword(password);
        Patient patient1=this.patientService.findPlogin(identification,password);
        List<Registration> list=this.registrationService.findabypid(pid);//查找挂号记录
        List<Evlauate> list1=this.evlauateService.findallnull(pid);//查找所有待评价
        List<Evlauate> list2 =this.evlauateService.finbypid(pid);//展示所有评价
        model.addAttribute("ev",list1);
        model.addAttribute("pt",patient1);
        model.addAttribute("re",list);
        model.addAttribute("myhis",list2);
        return "geren.html";

    }

    //进入提问页面
    @RequestMapping("tiwen.html")
    public String findtiwen(HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser==null){
            return "redirect:/plogin.html";//===>页面
        }
        return "tiwen.html";
    }

    //删除问题
    @RequestMapping("deleteprogreambyid")
    public String delbyid(String id){
        this.solvePatientService.del(id);
        this.problemService.delprobleambyid(id);
        return "redirect:/geren.html";
    }

    //自己修改信息
    @RequestMapping("update_pamyself.html")
    public String updatepatient(Patient patient, Model model,HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser==null){
            return "redirect:/plogin.html";//===>页面
        }
        String identification=puser.getIdentification();
        String password=puser.getPassword();
        patient.setIdentification(identification);
        patient.setPassword(password);
        Patient patient1=this.patientService.findPlogin(identification,password);
        model.addAttribute("pt",patient1);
        return "update_pamyself.html";
    }

    //进入公告页面时展示当天所有公告
    @RequestMapping("notice.html")
    public String findAnnbytime(Model model,Announcement announcement) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        Date date=sdf.parse(s);
        announcement.setReleaseTime(date);
        List<Announcement> list=announcementService.findAll();
        model.addAttribute("annt",list);
        return "notice.html";
    }

    @RequestMapping("plogin.html")
    public String toplogin(){
        return "plogin.html";
    }

    //请求挂号
    @RequestMapping("a")
    @ResponseBody
    public String addguahao(HttpSession session,String doctorname,String administrativeName,String doctorid,String startTime,Integer hang,Integer lie) throws ParseException {
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser==null){
            return "/plogin.html";//===>页面
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = format.parse(startTime);
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE) + lie);
        newtime = format.format(now.getTime());
        String sx=" ";
        String shangx=hang+"";
        if (shangx.equals("1")){
             sx="上午";
        }else {
          sx="下午";
        }
         this.thetime=newtime+sx;
         System.out.println(thetime);
         this.dname=doctorname;
         this.keshi=administrativeName;
         this.did=doctorid;
         return "guahao.html";
    }

    //生成挂号单
    @RequestMapping("guahao.html")
    public String toguo(Model model,Registration registration,HttpSession session)  {
        Patient puser = (Patient)session.getAttribute("puser");
        registration.setId(Utils.getUUID().substring(0,22));
        registration.setAdministrativeName(keshi);
        registration.setDoctorName(dname);
        registration.setPatientId(puser.getId());
        registration.setPatientName(puser.getName());
        registration.setTimedetails(thetime);
        registration.setDoctorid(did);
        registration.setIdentification(puser.getIdentification());
        registration.setCost("20元");
        registration.setStatus("未就诊");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();

      //  Date mdate=new Date();
        registration.setMytime(date);

        model.addAttribute("myreg",registration);
        return "guahao.html";
    }

    //查看问题
    @RequestMapping("newslist.html")
    public String newslist(String id,Model model){
        Problem one = problemService.findOne(id);
        model.addAttribute("problem",one);
        return "newslist.html";
    }

    //后台注销登录注销登录
    @RequestMapping("Cancellation")
    public String zhuxiao(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/tologin";
    }

    //前端注销登录
    @RequestMapping("pCancellation")
    public String dengchu(HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser!=null){
            session.removeAttribute("puser");
            return "redirect:/plogin.html";
        }
        return "redirect:/index.html";
    }

    @RequestMapping("findpingjiabyid")
    public String findbyidpingjia(String id,HttpSession session,Model model){
        Patient puser = (Patient)session.getAttribute("puser");
        if(puser==null){
            return "redirect:/plogin.html";//===>页面
        }
        Evlauate evlauate=evlauateService.findbyid(id);
        model.addAttribute("evla",evlauate);
        return "pingjia.html";
    }
    //修改评价
    @RequestMapping("updatepingjia")
    public String updatepingjia(String id,String context,Evlauate evlauate,String fangshi,HttpSession session){
        evlauate.setContext(context);
        evlauate.setId(id);
        Date t=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        evlauate.setTimer( df.format(t));
        if (fangshi.equals("1")){
            evlauate.setCommentator("匿名用户");
        }else {
            Patient puser = (Patient)session.getAttribute("puser");
           evlauate.setCommentator(puser.getName());
        }
       this.evlauateService.update(evlauate);
        return "redirect:/geren.html";
    }

    @RequestMapping("pingjia.html")
    public String uppingjia(){
        return "pingjia.html";
    }

    //查找所有公告
    @RequestMapping("findgonggaobyid")
    public String selgonggaobyid(String id,Model model){
        Announcement announcement=announcementService.findById(id);
        model.addAttribute("ance",announcement);
        return "/noticeshow.html";
    }

    //修改密码
    @RequestMapping("uppatientpwd")
    @ResponseBody
    public String uppssword(String pwd1,String pwd2,HttpSession session){
        Patient puser = (Patient)session.getAttribute("puser");
        if (pwd1.equals(pwd2)){
            String password=pwd1;
            patientService.uppwd(password,puser.getId());
            session.removeAttribute("puser");
            return "success";
        }
        return "error";
    }

    //修改密码
    @RequestMapping("updatepwd.html")
    public String touppwd(){
        return "updatepwd.html";
    }

    //展示所有评论
    @RequestMapping("My_evaluation")
    public String selallbydoctorid(HttpSession session,Model model){
        Doctor user = (Doctor) session.getAttribute("user");
        String doctorid=user.getId();
        List<Evlauate> list=evlauateService.findallbyid(doctorid);
        model.addAttribute("myevl",list);
        return "My_evaluation.html";
    }

    //查找医生旗下所有评论
    @RequestMapping("findevbyid")
    public String selevbyid(String id,Model model){
       Evlauate evlauate = this.evlauateService.findbyid(id);
        model.addAttribute("theev",evlauate);
        return "/showevlauate.html";
    }

    //查询挂号记录
    @RequestMapping("Article_record.html")
    public String findguahao(HttpSession session,Model model) throws ParseException {
        Doctor user = (Doctor) session.getAttribute("user");
        String doctorid=user.getId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        Date date=sdf.parse(s);
        List<Registration> mylist= registrationService.findByDoctorId(doctorid,date);//根据医生id查询今天以后所有挂号信息；
        model.addAttribute("gua",mylist);
        return "/Article_record.html";
    }

    //医生查看挂号病人信息
    @RequestMapping("finddetils")
    public String selpatient(String patientId,Model model){
        String id=patientId;
        Patient patient = patientService.findpatientByid(id);
        model.addAttribute("mypat",patient);
        return "/showpatient.html";
    }

    //病人删除评价
    @RequestMapping("deltheev")
    public String delbypid(String pid){
        this.evlauateService.delbypid(pid);
        return "redirect:/geren.html";
    }


}
