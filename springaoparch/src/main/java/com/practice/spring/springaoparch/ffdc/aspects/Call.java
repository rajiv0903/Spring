package com.practice.spring.springaoparch.ffdc.aspects;

import org.aspectj.lang.JoinPoint;

public class Call {
	
	private int depth;
	private String signatureAndParameter;
	private String result;
	
	public Call(JoinPoint joinPoint, int depth) {
		this.setDepth(depth);
		this.signatureAndParameter = formatSignatureAndParameter(joinPoint);
	}

	private String formatSignatureAndParameter(JoinPoint joinPoint) {
		StringBuilder builder = new StringBuilder();
		builder.append(joinPoint.getStaticPart().getSignature().toString());
		Object args[] = joinPoint.getArgs();
		if(args.length > 0) {
			builder.append(" Args ");
			for(Object arg: args) {
				builder.append(arg.toString());
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return signatureAndParameter +  (getResult() !=null? " result " +getResult() : "");
	}
	
	
}
