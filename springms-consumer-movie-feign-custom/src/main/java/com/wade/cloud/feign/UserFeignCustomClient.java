package com.wade.cloud.feign;

import com.wade.cloud.config.TestFeignCustomConfiguration;
import com.wade.cloud.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by tingyun on 2017/11/28.
 */
@FeignClient(name = "springms-provider-user", configuration = TestFeignCustomConfiguration.class)
public interface UserFeignCustomClient {
    /**
     * 这里的注解 RequestLine、Param 是 Feign 的配置新的注解，详细请参考链接：https://github.com/OpenFeign/feign
     *
     * @param id
     * @return
     */
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}

/****************************************************************************************
 参考代码如下：

 interface GitHub {
@RequestLine("GET /repos/{owner}/{repo}/contributors")
List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}

 static class Contributor {
 String login;
 int contributions;
 }

 public static void main(String... args) {
 GitHub github = Feign.builder().decoder(new GsonDecoder()).target(GitHub.class, "https://api.github.com");

 // Fetch and print a list of the contributors to this library.
 List<Contributor> contributors = github.contributors("OpenFeign", "feign");
 for (Contributor contributor : contributors) {
 System.out.println(contributor.login + " (" + contributor.contributions + ")");
 }
 }
 ****************************************************************************************/
