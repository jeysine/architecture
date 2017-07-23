package cn.com.architecture.entity;

import cn.com.architecture.util.DuplicateCodeVerificationUtil;

public class ApiCodes {

	public static final int STATUS_INVALID_HMAC_SIGNATURE = 4000;
	public static final int STATUS_INVALID_REQUEST = 4003;
	public static final int STATUS_MSISDN_REGISTRED = 4005;
	public static final int STATUS_MSISDN_AUTH_FAILED = 4006;
	public static final int STATUS_INVALID_TOKEN = 4007;
	public static final int STATUS_EXPIRED_TOKEN = 4008;
	public static final int STATUS_WRONG_OLD_PASSWORD = 4009;
	public static final int STATUS_MSISDN_LOCKED = 4010;
	public static final int STATUS_FORBIDDEN = 4011;
	public static final int STATUS_TEAM_NAME_USED_BY_THIS_DOCTOR = 4012;
	public static final int STATUS_TEAM_NOT_OWNER = 4013;
	public static final int STATUS_TEAM_NOT_EXISTING = 4014;
	public static final int STATUS_TEAM_EXISTING = 4015;
	public static final int STATUS_MUST_INVITE_FIRST = 4017;
	public static final int STATUS_OWNER_INVITING_SELF = 4018;

	public static final int STATUS_UNKNOWN_USER_ERROR = 4020;
	public static final int STATUS_PATIENT_IS_NOT_DOCTORS = 4021;
	public static final int STATUS_NO_PATIENT = 4022;
	public static final int STATUS_TEAM_NOT_OWNER_OR_MEMBER = 4023;
	public static final int STATUS_TAG_NOT_FOUND_OR_NOT_OWNED_BY_DOCTOR = 4024;

	public static final int STATUS_TAG_ALREADY_USED = 4025;
	public static final int STATUS_TAGS_INCOMPLETE_OR_NOT_MATCH = 4026;

	public static final int STATUS_BANK_CARD_EXISTING = 4028;
	public static final int STATUS_BANK_CARD_NOT_FOUND = 4029;
	public static final int STATUS_HEALTH_DATA_NOT_FOUND = 4030;
	public static final int STATUS_CANNOT_END_RELATIONSHIP = 4031;
	public static final int STATUS_PATIENT_DOCTOR_REF_NOT_FOUND = 4032;
	public static final int STATUS_TRANX_HISTORY_NOT_FOUND = 4033;
	public static final int STATUS_TEAM_PATIENT_NOT_JOINED = 4034;
	public static final int STATUS_REGISTRATION_INVALID_INVITE_CODE = 4035;
	public static final int STATUS_SERVICE_REMINDATION_SENT = 4036;
	public static final int STATUS_OUT_OF_LENGTH = 4037;// 超出长度

	public static final int STATUS_INTERNAL_ERROR = 5001;
	public static final int STATUS_BUSY = 5003;

	/* application codes */
	public static final int STATUS_FILE_NOT_FOUND = 4201;
	public static final int STATUS_IO_ERROR = 4202;

	public static final int STATUS_OK = 2000;
	public static final int STATUS_NOT_FOUND = 4444;
	public static final int STATUS_COMMON_NOT_AUTHORIZED = 4445;// 没有对应权限(通用)



	// 必须在所有public static final int之后
	// Java 的static初始化顺序先初始化常量，再调用static block
	static {
		DuplicateCodeVerificationUtil.assertNoDuplicatePulicStaticFinalInt(ApiCodes.class);
	}

	private ApiCodes() {
		super();
	}
}
