package com.zqx.hospitalmanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zqx.hospitalmanage.dao.DoctorDao;
import com.zqx.hospitalmanage.dao.MenuDao;
import com.zqx.hospitalmanage.dao.RoleDao;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.pojo.vo.DoctorInterfaceVO;
import com.zqx.hospitalmanage.service.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalmanageApplicationTests {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private DoctorService doctorService;

    @Test
    public void contextLoads() {
//        Doctor a = doctorDao.findByUsername("1");
//        System.out.println(a.getRole().get(0).getNummame());
    }
    @Test
    public void contextLoads1() {
//        contextLoads1System.out.println(roleDao.findAll());
        System.out.println(roleDao.findById("98109599982288897").get());

    }
    @Test
    public void contextLoads2() {
        Page<Doctor> page = doctorService.findAllByPage(1, 2);
        System.out.println(page);

    }


    @Test
    public void contextLoads4() {
        List<Doctor> list = doctorService.findByNameAndStartAndEnd("张晓", null,"2010-10-10");
        System.out.println(list.size());
        System.out.println(list);
    }















    @Test
    public void contextLoads3() {//测试查询VO对象
        List<Object[]> vo = doctorDao.findAllDoctorVO();
        for (Object[] o : vo) {
            for (Object o1 : o) {
                if(o1==null){
                    continue;
                }
                System.out.print(o1.toString()+',');
            }
//            System.out.println("o.length----------->"+o.length);
            System.out.println();
        }
    }
    @Test
    public void contextLoads5() {
        List<DoctorInterfaceVO> list = doctorDao.findAllDoctorInterVO();
        for (DoctorInterfaceVO vo : list) {
            Object o = JSONObject.toJSON(vo);
            Object json = JSONObject.toJSON(vo);
            JSONObject object = JSONObject.parseObject(json.toString());
            object.remove("target");
            object.remove("targetClass");

            System.out.println(JSONObject.toJSON(object));
//            System.out.println(vo.toStringInfo());
        }
        //,"targetClass":"org.springframework.data.jpa.repository.query.AbstractJpaQuery$TupleConverter$TupleBackedMap"
               //{"entryTime":1445270400000,"administrativeName":"妇产科","sex":"女","name":"张晓云","tel":"456456","id":"1cc9dbf139c244858364ee321bcd4159","job":"主治医生","status":"在职",
      //"target":{"entryTime":1445270400000,"administrativeName":"妇产科","sex":"女","name":"张晓云","tel":"456456","id":"1cc9dbf139c244858364ee321bcd4159","job":"主治医生","status":"在职"}}


    }



    public static <T> void caseEntity(List<Object[]> list,Class<T> clazz,Object model) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(methods[i].getName());
        }
        for (Method method : methods) {
        }
    }

    public static List<Map<String,Object>> getFiledsInfo(Object model){
        Field[] fields = model.getClass().getDeclaredFields();
        ArrayList<Map<String,Object>> list = new ArrayList<>(fields.length);
        Map infoMap = null;
        for (int i = 0; i < fields.length; i++) {
            infoMap = new HashMap(3);
            infoMap.put("type",fields[i].getType());
            infoMap.put("name",fields[i].getName());
            infoMap.put("value",getFieldValueByName(fields[i].getName(),model));
            list.add(infoMap);
        }
        return list;
    }
    public static Object getFieldValueByName(String fieldName,Object model){
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get"+firstLetter+fieldName.substring(1);
            Method method = model.getClass().getMethod(getter, new Class[]{});
            Object o = method.invoke(model, new Object[]{});
            return o;
        }catch (Exception e){
            return null;
        }



    }

}
