package app;

public class configuration {
	public static final String
	HOSTNAME = "lrp-csdb000.systems.wvu.edu",
	PORT = "2201",
	SID = "cs440",
	JDBC_URL = String.format(
		"jdbc:oracle:thin:@//%s:%s/%s",
		HOSTNAME,
		PORT,
		SID
	);

}
