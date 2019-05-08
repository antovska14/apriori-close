package com.students.moodle.info.data.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.interfaces.algorithm.Algorithm;
import com.students.moodle.info.data.result.interfaces.algorithm.Items;
import com.students.moodle.info.data.result.interfaces.result.alg.ResultAlg;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;
import com.students.moodle.info.data.services.dto.IdIpDTO;
import com.students.moodle.info.data.services.interfaces.ServiceIdIp;

public final class ServiceIdIpCombination implements ServiceIdIp {

	private static final String RESULT_FILE = "algorithm-result.txt";
	private static final String TABLE_DESCRIPTION = "id-ip-table";

	@Override
	public List<IdIpDTO> getMostFrequentUserIpAddressCombination() throws IOException {
		getResult();
		final List<IdIpDTO> list = new ArrayList<IdIpDTO>();
		list.add(new IdIpDTO("Dijana", "Antovska", "192.0"));
		list.add(new IdIpDTO("Gabrijela", "Petrov", "192.0"));
		return list;
	}

	private void getResult() throws IOException {
		final String algorithmResultFile = RESULT_FILE;
		final TransactionTable tt = FactoryResult.getImplementationTransactionTable(TABLE_DESCRIPTION);
		final ResultAlg result = FactoryResult.getResultAlg();
		final String resultFile = result.getResultFile(tt);
		final Algorithm algorithm = FactoryResult.getAlgorithm();
		final Items resultTable = algorithm.runAlgorithm(0.01, resultFile, algorithmResultFile);
	}
}
