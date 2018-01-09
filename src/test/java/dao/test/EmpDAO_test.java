package dao.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ctbc.dao.EmpDAO;
import com.ctbc.vo.EmpVO;

public class EmpDAO_test {

	private EmpDAO empDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		empDAO = new EmpDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int count = 0;
		for (EmpVO empVO : empDAO.getAll()) {
			System.out.println(empVO.toString());
			count++;
		}
		Assert.assertEquals("資料筆數錯誤！", 14/* excepted */, count);
	}

}
