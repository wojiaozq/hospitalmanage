package com.zqx.hospitalmanage;

import com.zqx.hospitalmanage.dao.DoctorDao;
import com.zqx.hospitalmanage.dao.MenuDao;
import com.zqx.hospitalmanage.dao.RoleDao;
import com.zqx.hospitalmanage.pojo.Doctor;
import com.zqx.hospitalmanage.pojo.Page;
import com.zqx.hospitalmanage.service.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.List;

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
    public void contextLoads3() {//测试查询VO对象
        List<Object[]> vo = doctorDao.findAllDoctorVO();
        for (Object[] o : vo) {
            for (Object o1 : o) {
                if(o1==null){
                    continue;
                }
                System.out.print(o1.toString()+',');
            }
            System.out.println("o.length----------->"+o.length);
        }
    }
    public static <T> void caseEntity(List<Object[]> list,Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < list.size(); i++) {


        }
        for (Method method : methods) {


        }


    }


}
