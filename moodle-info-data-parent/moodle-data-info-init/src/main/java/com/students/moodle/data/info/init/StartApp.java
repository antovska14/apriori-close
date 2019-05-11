package com.students.moodle.data.info.init;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.students.moodle.info.data.persistence.factory.FactoryPersistence;
import com.students.moodle.info.data.persistence.implementation.repository.UserRepositoryImplementation;
import com.students.moodle.info.data.persistence.implementation.utility.JpaUtility;
import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.implementation.algorithm.AlgoAprioriClose;
import com.students.moodle.info.data.result.implementation.result.alg.MapToIdIPTable;
import com.students.moodle.info.data.result.implementation.result.alg.Result;
import com.students.moodle.info.data.services.factory.FactoryService;
import com.students.moodle.info.data.services.implementation.ServiceIdIpCombination;

@WebListener
public final class StartApp implements ServletContextListener {

	@Override
	public void contextInitialized(final ServletContextEvent event) {
		System.out.println("?????????????????????????????????????????????????????????????");
		initializeFactoryResult();
		initializeFactoryPersistence();
		try {
			initializeFactoryService();
			System.out.println("?????????????????????????????????????????????????????????????");
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(final ServletContextEvent event) {
		JpaUtility.close();
	}

	private void initializeFactoryResult() {
		FactoryResult.setAlgorithm(new AlgoAprioriClose());
		FactoryResult.setResultAlg(new Result());
		FactoryResult.addTransactionTable("id-ip-table", new MapToIdIPTable());
	}

	private void initializeFactoryService() throws IOException {
		FactoryService.setServiceIdIp(new ServiceIdIpCombination());
		FactoryService.getServiceIdIp().getMostFrequentUserIpAddressCombination();
	}

	private void initializeFactoryPersistence() {
		JpaUtility.initializeEntityFactory();
		final EntityManager entityManager = JpaUtility.getEntityManager();
		FactoryPersistence.setUserRepository(new UserRepositoryImplementation(entityManager));
	}
}
