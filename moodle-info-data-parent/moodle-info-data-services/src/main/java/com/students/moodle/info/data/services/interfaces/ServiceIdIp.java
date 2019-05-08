package com.students.moodle.info.data.services.interfaces;

import java.io.IOException;
import java.util.List;

import com.students.moodle.info.data.services.dto.IdIpDTO;

public interface ServiceIdIp {
	public List<IdIpDTO> getMostFrequentUserIpAddressCombination() throws IOException;
}
