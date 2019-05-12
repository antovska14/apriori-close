package com.students.moodle.data.info.init;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.students.moodle.info.data.persistence.factory.FactoryPersistence;
import com.students.moodle.info.data.persistence.implementation.repository.UserRepositoryImplementation;
import com.students.moodle.info.data.persistence.implementation.utility.JpaUtility;
import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.implementation.algorithm.AlgoAprioriClose;
import com.students.moodle.info.data.result.implementation.result.alg.IdIpTableMapper;
import com.students.moodle.info.data.result.implementation.result.alg.Result;
import com.students.moodle.info.data.result.implementation.result.search.ResultUserDiscussion;
import com.students.moodle.info.data.services.factory.FactoryService;
import com.students.moodle.info.data.services.implementation.ServiceIdIpCombination;
import com.students.moodle.info.data.services.implementation.ServiceUserDiscussion;

@WebListener
public final class StartApp implements ServletContextListener {

	@Override
	public void contextInitialized(final ServletContextEvent event) {
		initializeFactoryResult();
		initializeFactoryPersistence();
		initializeFactoryService();
	}

	@Override
	public void contextDestroyed(final ServletContextEvent event) {
		JpaUtility.close();
	}

	private void initializeFactoryResult() {
		FactoryResult.setAlgorithm(new AlgoAprioriClose());
		FactoryResult.setResultAlg(new Result());
		FactoryResult.addTransactionTable("id-ip-table", new IdIpTableMapper());
		FactoryResult.addToSearchMap("user-discussion", new ResultUserDiscussion());
	}

	private void initializeFactoryService() {
		FactoryService.setServiceIdIp(new ServiceIdIpCombination());
		FactoryService.addToSearchMap("user-discussion", new ServiceUserDiscussion());
	}

	private void initializeFactoryPersistence() {
		JpaUtility.initializeEntityFactory();
		final EntityManager entityManager = JpaUtility.getEntityManager();
		FactoryPersistence.setUserRepository(new UserRepositoryImplementation(entityManager));
	}
}
