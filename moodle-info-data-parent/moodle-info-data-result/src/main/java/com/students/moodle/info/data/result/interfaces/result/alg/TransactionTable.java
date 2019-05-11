package com.students.moodle.info.data.result.interfaces.result.alg;

import java.io.IOException;
import java.util.List;

public interface TransactionTable {

	public List<List<Integer>> getTransactionTable() throws IOException;

	public List<String> decodeParams(List<String> params);

}