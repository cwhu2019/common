package cwhu.sdk;

import java.io.IOException;

import cwhu.common.exception.DataIsNullException;
import cwhu.common.exception.OstypeMissWatchException;
import cwhu.common.log.Log4j2Writer;
import cwhu.common.log.LoginitException;

/**
 * Hello world!
 */
public class SDKCommon {
    private static boolean iniited = false;// 是否初始化

    /**
     * 自定义运行目录字符串
     */
    public static final String RUNPATH = "maokoRun.path";

    /**
     * 初始化-初始化日志
     *
     * @throws LoginitException
     * @throws DataIsNullException
     * @throws OstypeMissWatchException
     */
    public synchronized static void init() throws LoginitException, OstypeMissWatchException, DataIsNullException {
        if (!iniited) {
            iniited = true;
            System.out.println("sdkcommon is initing....");
            Log4j2Writer.init();
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            init();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
