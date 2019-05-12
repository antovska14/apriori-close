package com.students.moodle.info.data.result.implementation.result.alg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.students.moodle.info.data.result.interfaces.result.alg.ResultAlg;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;

public final class Result implements ResultAlg {

	@Override
	public String getResultFile(final TransactionTable tt) throws IOException {
		final String resultFile = "result.txt";
		final List<List<Integer>> transactionTable = tt.getTransactionTable();
		writeToFile(transactionTable, resultFile);
		return resultFile;
	}

	private void writeToFile(final List<List<Integer>> transactionTable, final String fileName) throws IOException {
		final BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		try {

			for (int i = 0; i < transactionTable.size(); i++) {
				for (int j = 0; j < transactionTable.get(i).size(); j++) {
					if (j == transactionTable.get(i).size() - 1) {
						bw.write(transactionTable.get(i).get(j) + "");
					} else {
						bw.write(transactionTable.get(i).get(j) + " ");
					}
				}
				bw.newLine();
			}
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
}
