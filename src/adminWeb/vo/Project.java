package adminWeb.vo;

public class Project extends Auth{
	protected int 		project_no;
	protected double    lat;
	protected double    lng;
	protected String	lot;
	protected String 	roadFullAddr;
	protected String 	roadAddrPart1;
	protected String 	addrDetail;
	protected String 	startTime;
	protected String	endTime;
	protected String 	cam;
	protected String	camnum;
	protected String 	message;
	
	public int getProject_no() {
		return project_no;
	}
	public Project setProject_no(int project_no) {
		this.project_no = project_no;
		return this;
	}
	public double getLat() {
		return lat;
	}
	public Project setLat(double lat) {
		this.lat = lat;
		return this;
	}
	public double getLng() {
		return lng;
	}
	public Project setLng(double lng) {
		this.lng = lng;
		return this;
	}
	public String getLot() {
		return lot;
	}
	public Project setLot(String lot) {
		this.lot = lot;
		return this;
	}
	public String getRoadFullAddr() {
		return roadFullAddr;
	}
	public Project setRoadFullAddr(String roadFullAddr) {
		this.roadFullAddr = roadFullAddr;
		return this;
	}
	public String getRoadAddrPart1() {
		return roadAddrPart1;
	}
	public Project setRoadAddrPart1(String roadAddrPart1) {
		this.roadAddrPart1 = roadAddrPart1;
		return this;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public Project setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
		return this;
	}
	public String getStartTime() {
		return startTime;
	}
	public Project setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}
	public String getEndTime() {
		return endTime;
	}
	public Project setEndTime(String endTime) {
		this.endTime = endTime;
		return this;
	}
	public String getCam() {
		return cam;
	}
	public Project setCam(String cam) {
		this.cam = cam;
		return this;
	}
	public String getCamnum() {
		return camnum;
	}
	public Project setCamnum(String camnum) {
		this.camnum = camnum;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public Project setMessage(String message) {
		this.message = message;
		return this;
	}

	
	

}
