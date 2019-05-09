package com.students.moodle.data.info.init;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.students.moodle.info.data.persistence.implementation.model.JpaRole;
import com.students.moodle.info.data.persistence.implementation.model.JpaUser;
import com.students.moodle.info.data.persistence.interfaces.repository.JpaUtility;
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
		initializeFactoryResult();
		initializeFactoryService();
		try {
			FactoryService.getServiceIdIp().getMostFrequentUserIpAddressCombination();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final EntityManager entityManager = JpaUtility.getEntityManager();
		entityManager.getTransaction().begin();
		final JpaRole role = new JpaRole(2, "role");
		entityManager.persist(role);
		final JpaUser user = new JpaUser(1, "Mahesh", "Varanasi", role);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		System.out.println("aaaaaaaaaaaaaaaaaaaa");
		entityManager.close();
		JpaUtility.close();
		System.out.println("Entity saved.");
	}

	@Override
	public void contextDestroyed(final ServletContextEvent event) {
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
