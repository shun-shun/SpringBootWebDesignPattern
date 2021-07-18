package jp.ac.hcs.gondo.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReportEntity {
	
	private List<ReportData> list = new ArrayList<ReportData>();
}