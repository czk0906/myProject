package myProjeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hlst.demo.entity.ResponseParameterForInsert;
import com.hlst.demo.utils.JaxbUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { MyTest.class })
public class MyTest {
	


	@Test
	public void tess() {
		System.err.print("err");
		System.out.println("--------");
		System.out.print("out");
	}
}
