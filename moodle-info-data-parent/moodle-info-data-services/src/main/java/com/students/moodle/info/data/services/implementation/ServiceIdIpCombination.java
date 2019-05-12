package com.students.moodle.info.data.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.students.moodle.info.data.persistence.factory.FactoryPersistence;
import com.students.moodle.info.data.persistence.interfaces.repository.UserRepository;
import com.students.moodle.info.data.services.dto.DTOConverter;
import com.students.moodle.info.data.services.dto.IdIpDTO;
import com.students.moodle.info.data.services.interfaces.ServiceIdIp;

public final class ServiceIdIpCombination implements ServiceIdIp {

	private static final String RESULT_FILE = "algorithm-result.txt";
	private static final String TABLE_DESCRIPTION = "id-ip-table";

	@Override
	public List<IdIpDTO> getMostFrequentUserIpAddressCombination() throws IOException {
		final List<List<String>> result = AlgorithmFileResult.getResult(RESULT_FILE, TABLE_DESCRIPTION);
		final UserRepository userRepository = FactoryPersistence.getUserRepository();
		final List<IdIpDTO> list = new ArrayList<>();
		for (final List<String> idIp : result) {
			final IdIpDTO idIpDTO = DTOConverter
					.covertToIdIpDTO(userRepository.findUserWithId(Integer.parseInt(idIp.get(0))), idIp.get(1));
			list.add(idIpDTO);
		}

		return list;
	}

}
