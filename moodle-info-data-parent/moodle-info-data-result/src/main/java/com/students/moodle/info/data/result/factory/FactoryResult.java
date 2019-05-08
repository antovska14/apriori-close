package com.students.moodle.info.data.result.factory;

import java.util.HashMap;
import java.util.Map;

import com.students.moodle.info.data.result.interfaces.algorithm.Algorithm;
import com.students.moodle.info.data.result.interfaces.result.alg.ResultAlg;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;

public final class FactoryResult {

	private static Map<String, TransactionTable> factoryMap = new HashMap<>();
	private static ResultAlg result = null;
	private static Algorithm alg = null;

	private FactoryResult() {

	}

	public static void addTransactionTable(final String description, final TransactionTable transactionTable) {
		factoryMap.put(description, transactionTable);
	}

	public static TransactionTable getImplementationTransactionTable(final String description) {
		return factoryMap.get(description);
	}

	public static void setResultAlg(final ResultAlg resultAlg) {
		result = resultAlg;
	}

	public static ResultAlg getResultAlg() {
		return result;
	}

	public static void setAlgorithm(final Algorithm algorithm) {
		alg = algorithm;
	}

	public static Algorithm getAlgorithm() {
		return alg;
	}
}
