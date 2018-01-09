package dao.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ctbc.dao.DeptDAO;
import com.ctbc.vo.DeptVO;

public class DeptDAO_test {

	private DeptDAO deptDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deptDAO = new DeptDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int count = 0;
		for (DeptVO deptVO : deptDAO.getAll()) {
			System.out.println(deptVO.toString());
			count++;
		}
		Assert.assertEquals("資料筆數錯誤！", 4/* excepted */, count);
	}

}
