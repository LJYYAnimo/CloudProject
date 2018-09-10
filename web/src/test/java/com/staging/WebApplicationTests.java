package com.staging;

import com.staging.entity.Permission;
import com.staging.web.WebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class WebApplicationTests {

    private ArrayList list;

    @Test
    public void contextLoads() {
    }

    @Before
    public void iniData() {
        list = new ArrayList<>();
        Permission permission = new Permission();
        permission.setDes("5");
        list.add(permission);
    }

    @Test
    public void testArr(){
        int[][] arr={
                {1,2,3},
                {4,5,6,7},
                {7,7,7,7,7,9}
        };

        for(int[] value : arr){
            for(int i : value){
                System.out.println(i);
            }
        }
    }
}
