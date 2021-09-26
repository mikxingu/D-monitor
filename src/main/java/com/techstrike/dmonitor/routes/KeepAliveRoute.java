package com.techstrike.dmonitor.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KeepAliveRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("timer:keepalive?period=10000")
		.to("log:APPLICATION IS WORKING");
		
	}

}
