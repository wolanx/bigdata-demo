import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiTest {

    private static final String HDFS_PATH = "hdfs://localhost:8020";
    private static FileSystem fs;

    @Before
    public void prepare() {
        try {
            Configuration configuration = new Configuration();
            configuration.set("dfs.replication", "1"); // 不设置的话默认值为3
            fs = FileSystem.get(new URI(HDFS_PATH), configuration, "root");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mkDir() throws Exception {
        fs.mkdirs(new Path("/test0/"));
    }

    @Test
    public void copy2local() throws IOException {
        Path src = new Path("/test.log");
        Path dst = new Path(System.getProperty("user.home") + "/test");
        fs.copyToLocalFile(false, src, dst);
    }

}
