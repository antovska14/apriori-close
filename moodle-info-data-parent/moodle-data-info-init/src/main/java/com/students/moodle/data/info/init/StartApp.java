package com.students.moodle.data.info.init;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.implementation.algorithm.AlgoAprioriClose;
import com.students.moodle.info.data.result.implementation.result.alg.MapToIdIPTable;
import com.students.moodle.info.data.result.implementation.result.alg.Result;
import com.students.moodle.info.data.services.factory.FactoryService;
import com.students.moodle.info.data.services.implementation.ServiceIdIpCombination;

@WebListener
public final class StartApp implements ServletContextListener {

	// private final EntityManagerFactory entityFactory =
	// Persistence.createEntityManagerFactory("persistence");

	@Override
	public void contextInitialized(final ServletContextEvent event) {
		initializeFactoryResult();
		initializeFactoryService();
		try {
			FactoryService.getServiceIdIp().getMostFrequentUserIpAddressCombination();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(final ServletContextEvent event) {
		/*
		 * if (entityFactory != null) { entityFactory.close(); }
		 */
	}

	private void initializeFactoryResult() {
		FactoryResult.setAlgorithm(new AlgoAprioriClose());
		FactoryResult.setResultAlg(new Result());
		FactoryResult.addTransactionTable("id-ip-table", new MapToIdIPTable());
	}

	private void initializeFactoryService() {
		FactoryService.setServiceIdIp(new ServiceIdIpCombination());
	}
}
