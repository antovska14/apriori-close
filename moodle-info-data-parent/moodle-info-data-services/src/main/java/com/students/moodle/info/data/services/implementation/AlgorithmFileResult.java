package com.students.moodle.info.data.services.implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.interfaces.algorithm.Algorithm;
import com.students.moodle.info.data.result.interfaces.result.alg.ResultAlg;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;

public final class AlgorithmFileResult {

	private AlgorithmFileResult() {

	}

	public static List<List<String>> getResult(final String algorithmResultFile, final String tableDescription)
			throws IOException {
		final TransactionTable tt = FactoryResult.getTransactionTable(tableDescription);
		final ResultAlg result = FactoryResult.getResultAlg();
		final String resultFile = result.getResultFile(tt);
		final Algorithm algorithm = FactoryResult.getAlgorithm();
		algorithm.runAlgorithm(0.01, resultFile, algorithmResultFile);
		final List<List<String>> list = readFromResultFile(algorithmResultFile);
		final List<String> params = new ArrayList<>();
		for (final List<String> row : list) {
			params.add(row.get(1));
		}
		final List<String> decodedParams = tt.decodeParams(params);
		final List<List<String>> decodedList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			final List<String> decodedRow = new ArrayList<>();
			decodedRow.add(list.get(i).get(0));
			decodedRow.add(decodedParams.get(i));
			decodedList.add(decodedRow);
		}
		return decodedList;
	}

	private static List<List<String>> readFromResultFile(final String resultFile) throws IOException {
		List<List<String>> list;
		final BufferedReader br = new BufferedReader(new FileReader(resultFile));
		try {
			String fileRow;
			list = new ArrayList<>();
			br.readLine();
			while ((fileRow = br.readLine()) != null) {
				final String[] values = fileRow.split("\\s+");
				if (values.length == 4) {
					final String param1 = values[0];
					final String param2 = values[1];
					final List<String> row = new ArrayList<>();
					row.add(param1);
					row.add(param2);
					list.add(row);
				}
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return list;
	}

}
