package com.rongsm.app;

import com.rongsm.app.bean.NewResultModel;
import com.rongsm.app.bean.OldResult;
import com.rongsm.app.bean.OldResultModel;
import com.rongsm.app.event.EventTagConstant;
import com.rongsm.app.event.EventHandler;
import com.rongsm.app.event.StatusChangedEvent;
import com.rongsm.app.utils.MoocUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private EventHandler eventHandler;

	@Test
	void testListener() {
		OldResult oldResult = new OldResult();
		oldResult.setOldAge(18);
		oldResult.setOldName("oldName");
		oldResult.setOldSex("man");
		OldResultModel oldResultModel = new OldResultModel();
		oldResultModel.setOldResult(oldResult);
		oldResultModel.setType(MoocUtil.FASTJSON);
		NewResultModel newResultModel = MoocUtil.convert(oldResultModel);
		System.out.println(newResultModel);

	}

	@Test
	public void testListener2(){
		StatusChangedEvent event = new StatusChangedEvent();
		//topic字段在这里没用到
		event.setTopic("default");
		event.setTag(EventTagConstant.INSERT);
		event.setContent("content");
		eventHandler.handleEvent(event);
	}
}
