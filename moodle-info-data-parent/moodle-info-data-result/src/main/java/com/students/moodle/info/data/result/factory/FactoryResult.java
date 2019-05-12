package com.students.moodle.info.data.result.factory;

import java.util.HashMap;
import java.util.Map;

import com.students.moodle.info.data.result.interfaces.algorithm.Algorithm;
import com.students.moodle.info.data.result.interfaces.result.alg.ResultAlg;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;
import com.students.moodle.info.data.result.interfaces.result.search.SearchResult;

public final class FactoryResult {

	private static Map<String, TransactionTable> transactionTableMap = new HashMap<>();
	private static Map<String, SearchResult> searchMap = new HashMap<>();
	private static ResultAlg result = null;
	private static Algorithm alg = null;

	private FactoryResult() {

	}

	public static void addTransactionTable(final String description, final TransactionTable transactionTable) {
		transactionTableMap.put(description, transactionTable);
	}

	public static TransactionTable getTransactionTable(final String description) {
		return transactionTableMap.get(description);
	}

	public static void addToSearchMap(final String description, final SearchResult searchResult) {
		searchMap.put(description, searchResult);
	}

	public static SearchResult getSearchMapMode(final String key) {
		return searchMap.get(key);
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
