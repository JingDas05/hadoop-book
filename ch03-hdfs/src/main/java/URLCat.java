// cc URLCat Displays files from a Hadoop filesystem on standard output using a URLStreamHandler

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

// vv URLCat
public class URLCat {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    // export HADOOP_CLASSPATH=/home/wusi/soft/hadoop/test/ch3/ch03-hdfs-4.0.jar
    // hadoop URLCat hdfs://192.168.1.3:9000/home/wusi/simple2.txt

    public static void main(String[] args) throws Exception {
        InputStream in = null;
        try {
            in = new URL(args[0]).openStream();
            // copyBytes() 值得学习的方法
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
// ^^ URLCat
