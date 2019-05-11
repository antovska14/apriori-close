package com.students.moodle.info.data.result.interfaces.algorithm;

import java.io.IOException;

import com.students.moodle.info.data.result.implementation.algorithm.Itemsets;

public interface Algorithm {

	Itemsets runAlgorithm(double d, String resultFile, String algorithmResultFile) throws IOException;

}
