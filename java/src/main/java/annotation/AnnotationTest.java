package annotation;

import org.atteo.classindex.ClassIndex;
import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/7 6:46 下午
 */
@Test
public class AnnotationTest {

    public static void main(String[] args) {
        Iterable<Class<?>> klasses = ClassIndex.getAnnotated(Test.class);
        int a = 1;
    }
}
