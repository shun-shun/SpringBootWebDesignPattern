package jp.ac.hcs.gondo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import jp.ac.hcs.gondo.domain.model.ReportData;
import lombok.Data;

@Data
public class ReportEntity {
	
	private List<ReportData> list = new ArrayList<ReportData>();
}