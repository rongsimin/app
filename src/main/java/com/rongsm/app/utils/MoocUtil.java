package com.rongsm.app.utils;

import com.rongsm.app.bean.NewResult;
import com.rongsm.app.bean.NewResultModel;
import com.rongsm.app.bean.OldResultModel;

/**
 * @author rongsimin
 * @date 2020/7/11 17:01
 */
public class MoocUtil {

	public static final String FASTJSON = "fastjson";
	public static final String JACKSON = "jackson";

	public static NewResultModel convert(OldResultModel oldResultModel) {
		NewResultModel newResultModel = new NewResultModel();
		NewResult newResult = new NewResult();
		newResult.setNewAge(oldResultModel.getOldResult().getOldAge());
		newResult.setNewName(oldResultModel.getOldResult().getOldName());
		newResult.setNewSex(oldResultModel.getOldResult().getOldSex());
		if (FASTJSON.equals(oldResultModel.getType())) {
//			FastjsonSerialize fastjsonSerialize = MoocSpringContainer.getInstance().getBean(FastjsonSerialize.class);
			FastjsonSerialize fastjsonSerialize = SpringContainerHolder.getAc().getBean(FastjsonSerialize.class);
			String oldResultDesc = fastjsonSerialize.serialize(oldResultModel.getOldResult());
			newResultModel.setOldResultDesc(oldResultDesc);
		} else if (JACKSON.equals(oldResultModel.getType())) {
//			JacksonSerialize jacksonSerialize = MoocSpringContainer.getInstance().getBean(JacksonSerialize.class);
			JacksonSerialize jacksonSerialize = SpringContainerHolder.getAc().getBean(JacksonSerialize.class);
			String oldResultDesc = jacksonSerialize.serialize(oldResultModel.getOldResult());
			newResultModel.setOldResultDesc(oldResultDesc);
		}
		newResultModel.setNewResult(newResult);
		return newResultModel;
	}
}
