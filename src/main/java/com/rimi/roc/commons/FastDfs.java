package com.rimi.roc.commons;



import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Properties;

/**
 * @author 惜-梦
 * @description 文件上传
 * @date 2019-03-01 11:43
 */
@Slf4j
@Component
public class FastDfs {

    @Value("fastdfs.tracher_servers")
    private String tracherServers;
    {

        try {
            Properties props = new Properties();
            props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS,tracherServers);
            ClientGlobal.initByProperties(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    /**
     * 上传
     */
    public String[] upload(MultipartFile file) throws IOException, MyException {
        StorageClient storageClient = getStorageClient();
        //获取全文件名
        String filename = file.getOriginalFilename();
        //获取文件的后缀名
        String fileExtName = filename.substring(filename.lastIndexOf("."));
        //上传文件并返回文件上传的文件名
        String[] result = storageClient.upload_file(file.getBytes(), fileExtName, null);
        //result[0] 存储文件的组名   the group name to store the file
        //result[1] 新建的文件名    the new create filename
        return result;
    }


    private StorageClient getStorageClient() throws IOException {
        return new StorageClient(getTrackerServer(),null);
    }

    private TrackerServer getTrackerServer() throws IOException {
        TrackerClient tracherClient = new TrackerClient();
        return  tracherClient.getConnection();
    }
}
