import com.beust.jcommander.internal.Lists;
import com.rockyzhu.datamodel.Spider;
import com.rockyzhu.db.SpiderReadDao;
import com.rockyzhu.db.SpiderReadDaoImpl;
import com.rockyzhu.db.SpiderWriteDao;
import com.rockyzhu.db.SpiderWriteDaoImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by hozhu on 11/29/16.
 */
public class TestSpiderDao {

  private List<Integer> _spiderIds;
  private SpiderWriteDao _spiderWriteDao;
  private SpiderReadDao _spiderReadDao;
  private BasicDataSource _dataSource;

  @BeforeMethod
  public void setup() {
    _dataSource = new BasicDataSource();
    _dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    _dataSource.setUrl("jdbc:oracle:thin:ubiquity/ubiquity@devdb:1521/DB");
    _spiderWriteDao = new SpiderWriteDaoImpl(_dataSource);
    _spiderReadDao = new SpiderReadDaoImpl(_dataSource);
    _spiderIds = Lists.newArrayList();
  }

  @AfterMethod
  public void testDown() {
    _spiderIds.forEach(id -> _spiderWriteDao.delete(id));
  }

  @Test
  public void test() {

    Spider spider = new Spider()
        .setSpiderId(123)
        .setActive(true)
        .setName("a name")
        .setType(Spider.SpiderType.XYZ);

    _spiderWriteDao.insert(spider); // this returns the id of the record in the database
    _spiderIds.add(spider.getSpiderId());
    Spider spiderDB = _spiderReadDao.get(spider.getSpiderId());
    Assert.assertEquals((int)spiderDB.getSpiderId(), 123);
    Assert.assertEquals((boolean)spiderDB.isActive(), true);
    Assert.assertEquals(spiderDB.getName(), "a name");
    Assert.assertEquals(spiderDB.getType(), Spider.SpiderType.XYZ);

    spider.setName("A new Name");
    _spiderWriteDao.update(spider);
    Spider spiderDbUpdated = _spiderReadDao.get(spider.getSpiderId());
    Assert.assertEquals((int)spiderDbUpdated.getSpiderId(), 123);
    Assert.assertEquals((boolean)spiderDbUpdated.isActive(), true);
    Assert.assertEquals(spiderDbUpdated.getName(), "A new Name");
    Assert.assertEquals(spiderDbUpdated.getType(), Spider.SpiderType.XYZ);
  }
}
