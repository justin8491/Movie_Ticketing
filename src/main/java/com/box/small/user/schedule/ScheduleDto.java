package com.box.small.user.schedule;

public class ScheduleDto {

	    private int sch_no;
	    private int mo_no;
	    private int sc_no;
	    private int sch_status;
	    private String sch_date;
	    private String sch_startTime;
	    private String sch_endTime;
	    
	    
		public ScheduleDto() {
			super();
		}
		public ScheduleDto(int sch_no, int mo_no, int sc_no, int sch_status, String sch_date, String sch_startTime,
				String sch_endTime) {
			super();
			this.sch_no = sch_no;
			this.mo_no = mo_no;
			this.sc_no = sc_no;
			this.sch_status = sch_status;
			this.sch_date = sch_date;
			this.sch_startTime = sch_startTime;
			this.sch_endTime = sch_endTime;
		}
		public int getSch_no() {
			return sch_no;
		}
		public void setSch_no(int sch_no) {
			this.sch_no = sch_no;
		}
		public int getMo_no() {
			return mo_no;
		}
		public void setMo_no(int mo_no) {
			this.mo_no = mo_no;
		}
		public int getSc_no() {
			return sc_no;
		}
		public void setSc_no(int sc_no) {
			this.sc_no = sc_no;
		}
		public int getSch_status() {
			return sch_status;
		}
		public void setSch_status(int sch_status) {
			this.sch_status = sch_status;
		}
		public String getSch_date() {
			return sch_date;
		}
		public void setSch_date(String sch_date) {
			this.sch_date = sch_date;
		}
		public String getSch_startTime() {
			return sch_startTime;
		}
		public void setSch_startTime(String sch_startTime) {
			this.sch_startTime = sch_startTime;
		}
		public String getSch_endTime() {
			return sch_endTime;
		}
		public void setSch_endTime(String sch_endTime) {
			this.sch_endTime = sch_endTime;
		}
		@Override
		public String toString() {
			return "ScheduleDto [sch_no=" + sch_no + ", mo_no=" + mo_no + ", sc_no=" + sc_no + ", sch_status="
					+ sch_status + ", sch_date=" + sch_date + ", sch_startTime=" + sch_startTime + ", sch_endTime="
					+ sch_endTime + "]";
		}
	    
	    
}
