package com.meite.springcloud.openfeign.order.httpclient;

import com.meite.springcloud.openfeign.api.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "springcloud-openfeign-member")
public interface MemberServiceFeign extends MemberService {

}
