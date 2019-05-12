package com.students.moodle.info.data.services.implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.students.moodle.info.data.persistence.factory.FactoryPersistence;
import com.students.moodle.info.data.persistence.interfaces.repository.UserRepository;
import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.interfaces.algorithm.Algorithm;
import com.students.moodle.info.data.result.interfaces.result.alg.ResultAlg;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;
import com.students.moodle.info.data.services.dto.DTOConverter;
import com.students.moodle.info.data.services.dto.IdIpDTO;
import com.students.moodle.info.data.services.interfaces.ServiceIdIp;

public final class ServiceIdIpCombination implements ServiceIdIp {

	private static final String RESULT_FILE = "algorithm-result.txt";
	private static final String TABLE_DESCRIPTION = "id-ip-table";

	@Override
	public List<IdIpDTO> getMostFrequentUserIpAddressCombination() throws IOException {
		final List<List<String>> result = getResult();
		final UserRepository userRepository = FactoryPersistence.getUserRepository();
		final List<IdIpDTO> list = new ArrayList<>();
		for (final List<String> idIp : result) {
			final IdIpDTO idIpDTO = DTOConverter
					.covertToIdIpDTO(userRepository.findUserWithId(Integer.parseInt(idIp.get(0))), idIp.get(1));
			list.add(idIpDTO);
		}

		return list;
	}

	private List<List<String>> getResult() throws IOException {
		final String algorithmResultFile = RESULT_FILE;
		final TransactionTable tt = FactoryResult.getTransactionTable(TABLE_DESCRIPTION);
		final ResultAlg result = FactoryResult.getResultAlg();
		final String resultFile = result.getResultFile(tt);
		final Algorithm algorithm = FactoryResult.getAlgorithm();
		algorithm.runAlgorithm(0.01, resultFile, algorithmResultFile);
		final List<List<String>> idIpList = readfromResultFile();
		final List<String> hashedIpAdresses = new ArrayList<>();
		for (final List<String> row : idIpList) {
			hashedIpAdresses.add(row.get(1));
		}
		final List<String> decodedIpAdresses = tt.decodeParams(hashedIpAdresses);
		final List<List<String>> decodedIpIdList = new ArrayList<>();
		for (int i = 0; i < idIpList.size(); i++) {
			final List<String> decodedIpIdRow = new ArrayList<>();
			decodedIpIdRow.add(idIpList.get(i).get(0));
			decodedIpIdRow.add(decodedIpAdresses.get(i));
			decodedIpIdList.add(decodedIpIdRow);
		}
		return decodedIpIdList;
	}

	private List<List<String>> readfromResultFile() throws IOException {
		List<List<String>> idIpList;
		final BufferedReader br = new BufferedReader(new FileReader(RESULT_FILE));
		try {
			String fileRow;
			idIpList = new ArrayList<>();
			br.readLine();
			while ((fileRow = br.readLine()) != null) {
				final String[] values = fileRow.split("\\s+");
				if (values.length == 4) {
					final String id = values[0];
					final String ipAddress = values[1];
					final List<String> idIpRow = new ArrayList<>();
					idIpRow.add(id);
					idIpRow.add(ipAddress);
					idIpList.add(idIpRow);
				}
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return idIpList;
	}
}
