package com.oc.oneflow.master;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.oc.oneflow.common.utils.ConfigUtil;
import com.oc.oneflow.model.ConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;


@SpringBootApplication
@ComponentScan(basePackages ={"com.oc.oneflow" })
public class Application {

    @Autowired
    private ConfigUtil configUtil;

    private static final Logger appLogger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @PostConstruct
    public void run() throws FileNotFoundException {
        ConfigVO configVO = configUtil.getConfigVO();
        System.out.println(configVO.getProjectId());
        System.out.println(configVO.getProjectName());
    }

}
