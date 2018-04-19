package eu.europa.esig.dss.validation;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import eu.europa.esig.dss.DSSUtils;
import eu.europa.esig.dss.client.http.IgnoreDataLoader;
import eu.europa.esig.dss.client.http.commons.CommonsDataLoader;
import eu.europa.esig.dss.utils.Utils;
import eu.europa.esig.dss.x509.CertificatePool;
import eu.europa.esig.dss.x509.CertificateSource;
import eu.europa.esig.dss.x509.CertificateToken;
import eu.europa.esig.dss.x509.CommonTrustedCertificateSource;
import eu.europa.esig.dss.x509.TimestampType;

public class SignatureValidationContextTest {

	@Test
	public void test() throws Exception {
		CertificateVerifier certificateVerifier = new CommonCertificateVerifier();
		CertificateSource certSource = new CommonTrustedCertificateSource();
		certSource.addCertificate(DSSUtils.loadCertificateFromBase64EncodedString(
				"MIIDZDCCAkygAwIBAgICC7gwDQYJKoZIhvcNAQELBQAwRDELMAkGA1UEBhMCTFUxFjAUBgNVBAoTDUx1eFRydXN0IHMuYS4xHTAbBgNVBAMTFEx1eFRydXN0IEdsb2JhbCBSb290MB4XDTExMDMxNzA5NTEzN1oXDTIxMDMxNzA5NTEzN1owRDELMAkGA1UEBhMCTFUxFjAUBgNVBAoTDUx1eFRydXN0IHMuYS4xHTAbBgNVBAMTFEx1eFRydXN0IEdsb2JhbCBSb290MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsn+nQPAiygz267Hxyw6VV0B1r6A/Ps7sqjJX5hmxZ0OYWmt8s7j6eJyqpoSyYBuAQc5jzR8XCJmk9e8+EsdMsFeaXHhAePxFjdqRZ9w6Ubltc+a3OY52OrQfBfVpVfmTz3iISr6qm9d7R1tGBEyCFqY19vx039a0r9jitScRdFmiwmYsaArhmIiIPIoFdRTjuK7zCISbasE/MRivJ6VLm6T9eTHemD0OYcqHmMH4ijCc+j4z1aXEAwfh95Z0GAAnOCfRK6qq4UFFi2/xJcLcopeVx0IUM115hCNq52XAV6DYXaljAeew5Ivo+MVjuOVsdJA9x3f8K7p56aTGEnin/wIDAQABo2AwXjAMBgNVHRMEBTADAQH/MA4GA1UdDwEB/wQEAwIBBjAfBgNVHSMEGDAWgBQXFYWJCS8kh28/HRvk8pZ5g0gTzjAdBgNVHQ4EFgQUFxWFiQkvJIdvPx0b5PKWeYNIE84wDQYJKoZIhvcNAQELBQADggEBAFrwHNDUUM9Bfua4nX3DcNBeNv9ujnov3kgR1TQuPLdFwlQlp+HBHjeDtpSutkVIA+qVvuucarQ3XB8u02uCgUNbCj8RVWOs+nwIAjegPDkEM/6XMshS5dklTbDG7mgfcKpzzlcD3H0KDTPy0lrfCmw7zBFRlxqkIaKFNQLXgCLShLL4wKpov9XrqsMLq6F8K/f1O4fhVFfsBSTveUJO84ton+Ruy4KZycwq3FPCH3CDqyEPVrRI/98HIrOM+R2mBN8tAza53W/+MYhm/2xtRDSvCHc+JtJy9LtHVpM8mGPhM7uZI5K1g3noHZ9nrWLWidb2/CfeMifLhNp3hSGhEiE="));
		certificateVerifier.setTrustedCertSource(certSource);

		SignatureValidationContext svc = new SignatureValidationContext();
		svc.initialize(certificateVerifier);
		CertificateToken certificateToken = DSSUtils.loadCertificateFromBase64EncodedString(
				"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");
		svc.addCertificateTokenForVerification(certificateToken);
		svc.addCertificateTokenForVerification(certificateToken); // add twice for test

		TimestampToken timestampToken = new TimestampToken(Utils.fromBase64(
				"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"),
				TimestampType.SIGNATURE_TIMESTAMP, new CertificatePool());
		svc.addTimestampTokenForVerification(timestampToken);
		svc.addTimestampTokenForVerification(timestampToken); // add twice for test

		svc.validate();

		Set<CertificateToken> processedCertificates = svc.getProcessedCertificates();
		assertEquals(4, processedCertificates.size()); // cert chain + 1 cert for tsp

		Set<TimestampToken> processedTimestamps = svc.getProcessedTimestamps();
		assertEquals(1, processedTimestamps.size());
	}

	@Test
	public void testCannotDownload() throws Exception {
		CertificateVerifier certificateVerifier = new CommonCertificateVerifier();
		CertificateSource certSource = new CommonTrustedCertificateSource();
		certSource.addCertificate(DSSUtils.loadCertificateFromBase64EncodedString(
				"MIIDZDCCAkygAwIBAgICC7gwDQYJKoZIhvcNAQELBQAwRDELMAkGA1UEBhMCTFUxFjAUBgNVBAoTDUx1eFRydXN0IHMuYS4xHTAbBgNVBAMTFEx1eFRydXN0IEdsb2JhbCBSb290MB4XDTExMDMxNzA5NTEzN1oXDTIxMDMxNzA5NTEzN1owRDELMAkGA1UEBhMCTFUxFjAUBgNVBAoTDUx1eFRydXN0IHMuYS4xHTAbBgNVBAMTFEx1eFRydXN0IEdsb2JhbCBSb290MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsn+nQPAiygz267Hxyw6VV0B1r6A/Ps7sqjJX5hmxZ0OYWmt8s7j6eJyqpoSyYBuAQc5jzR8XCJmk9e8+EsdMsFeaXHhAePxFjdqRZ9w6Ubltc+a3OY52OrQfBfVpVfmTz3iISr6qm9d7R1tGBEyCFqY19vx039a0r9jitScRdFmiwmYsaArhmIiIPIoFdRTjuK7zCISbasE/MRivJ6VLm6T9eTHemD0OYcqHmMH4ijCc+j4z1aXEAwfh95Z0GAAnOCfRK6qq4UFFi2/xJcLcopeVx0IUM115hCNq52XAV6DYXaljAeew5Ivo+MVjuOVsdJA9x3f8K7p56aTGEnin/wIDAQABo2AwXjAMBgNVHRMEBTADAQH/MA4GA1UdDwEB/wQEAwIBBjAfBgNVHSMEGDAWgBQXFYWJCS8kh28/HRvk8pZ5g0gTzjAdBgNVHQ4EFgQUFxWFiQkvJIdvPx0b5PKWeYNIE84wDQYJKoZIhvcNAQELBQADggEBAFrwHNDUUM9Bfua4nX3DcNBeNv9ujnov3kgR1TQuPLdFwlQlp+HBHjeDtpSutkVIA+qVvuucarQ3XB8u02uCgUNbCj8RVWOs+nwIAjegPDkEM/6XMshS5dklTbDG7mgfcKpzzlcD3H0KDTPy0lrfCmw7zBFRlxqkIaKFNQLXgCLShLL4wKpov9XrqsMLq6F8K/f1O4fhVFfsBSTveUJO84ton+Ruy4KZycwq3FPCH3CDqyEPVrRI/98HIrOM+R2mBN8tAza53W/+MYhm/2xtRDSvCHc+JtJy9LtHVpM8mGPhM7uZI5K1g3noHZ9nrWLWidb2/CfeMifLhNp3hSGhEiE="));
		certificateVerifier.setTrustedCertSource(certSource);

		certificateVerifier.setDataLoader(new IgnoreDataLoader());

		ValidationContext vc = new SignatureValidationContext();
		vc.initialize(certificateVerifier);
		CertificateToken certificateToken = DSSUtils.loadCertificateFromBase64EncodedString(
				"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");
		vc.addCertificateTokenForVerification(certificateToken);

		TimestampToken timestampToken = new TimestampToken(Utils.fromBase64(
				"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"),
				TimestampType.SIGNATURE_TIMESTAMP, new CertificatePool());
		vc.addTimestampTokenForVerification(timestampToken);

		vc.validate();

		Set<CertificateToken> processedCertificates = vc.getProcessedCertificates();
		assertEquals(2, processedCertificates.size()); // cert + tsp cert

		Set<TimestampToken> processedTimestamps = vc.getProcessedTimestamps();
		assertEquals(1, processedTimestamps.size());
	}

	@Test
	public void testBridgeCertificateMovesUpInsteadofSidewaysOnValidation() throws Exception {
		CertificateVerifier certificateVerifier = new CommonCertificateVerifier();
		CertificateSource certSource = new CommonTrustedCertificateSource();
		certSource.addCertificate(DSSUtils.loadCertificateFromBase64EncodedString(
				"MIIEYDCCA0igAwIBAgICATAwDQYJKoZIhvcNAQELBQAwWTELMAkGA1UEBhMCVVMxGDAWBgNVBAoTD1UuUy4gR292ZXJubWVudDENMAsGA1UECxMERlBLSTEhMB8GA1UEAxMYRmVkZXJhbCBDb21tb24gUG9saWN5IENBMB4XDTEwMTIwMTE2NDUyN1oXDTMwMTIwMTE2NDUyN1owWTELMAkGA1UEBhMCVVMxGDAWBgNVBAoTD1UuUy4gR292ZXJubWVudDENMAsGA1UECxMERlBLSTEhMB8GA1UEAxMYRmVkZXJhbCBDb21tb24gUG9saWN5IENBMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2HX7NRY0WkG/Wq9cMAQUHK14RLXqJup1YcfNNnn4fNi9KVFmWSHjeavUeL6wLbCh1bI1FiPQzB6+Duir3MPJ1hLXp3JoGDG4FyKyPn66CG3G/dFYLGmgA/Aqo/Y/ISU937cyxY4nsyOl4FKzXZbpsLjFxZ+7xaBugkC7xScFNknWJidpDDSPzyd6KgqjQV+NHQOGgxXgVcHFmCye7Bpy3EjBPvmE0oSCwRvDdDa3ucc2Mnr4MrbQNq4iGDGMUHMhnv6DOzCIJOPpwX7e7ZjHH5IQip9bYi+dpLzVhW86/clTpyBLqtsgqyFOHQ1O5piF5asRR12dP8QjwOMUBm7+nQIDAQABo4IBMDCCASwwDwYDVR0TAQH/BAUwAwEB/zCB6QYIKwYBBQUHAQsEgdwwgdkwPwYIKwYBBQUHMAWGM2h0dHA6Ly9odHRwLmZwa2kuZ292L2ZjcGNhL2NhQ2VydHNJc3N1ZWRCeWZjcGNhLnA3YzCBlQYIKwYBBQUHMAWGgYhsZGFwOi8vbGRhcC5mcGtpLmdvdi9jbj1GZWRlcmFsJTIwQ29tbW9uJTIwUG9saWN5JTIwQ0Esb3U9RlBLSSxvPVUuUy4lMjBHb3Zlcm5tZW50LGM9VVM/Y0FDZXJ0aWZpY2F0ZTtiaW5hcnksY3Jvc3NDZXJ0aWZpY2F0ZVBhaXI7YmluYXJ5MA4GA1UdDwEB/wQEAwIBBjAdBgNVHQ4EFgQUrQx6dVzl85jEeZgOrCj9l/TnAvwwDQYJKoZIhvcNAQELBQADggEBAI9z2uF/gLGH9uwsz9GEYx728Yi3mvIRte9UrYpuGDco71wb5O9Qt2wmGCMiTR0mRyDpCZzicGJxqxHPkYnos/UqoEfAFMtOQsHdDA4b8Idb7OV316rgVNdF9IU+7LQd3nyKf1tNnJaK0KIyn9psMQz4pO9+c+iR3Ah6cFqgr2KBWfgAdKLI3VTKQVZHvenAT+0g3eOlCd+uKML80cgX2BLHb94u6b2akfI8WpQukSKAiaGMWMyDeiYZdQKlDn0KJnNR6obLB6jI/WNaNZvSr79PMUjBhHDbNXuaGQ/lj/RqDG8z2esccKIN47lQA2EC/0rskqTcLe4qNJMHtyznGI8="));
		certificateVerifier.setTrustedCertSource(certSource);

		certificateVerifier.setDataLoader(new CommonsDataLoader()); // Using commons to test that no 

		ValidationContext vc = new SignatureValidationContext();
		vc.initialize(certificateVerifier);
		CertificateToken certificateToken = DSSUtils.loadCertificateFromBase64EncodedString(
				"MIIFSzCCBDOgAwIBAgIQY1NDO8Vfvy5VCrBZTWzlwzANBgkqhkiG9w0BAQsFADCBgTELMAkGA1UEBhMCVVMxHTAbBgNVBAoTFFN5bWFudGVjIENvcnBvcmF0aW9uMR8wHQYDVQQLExZTeW1hbnRlYyBUcnVzdCBOZXR3b3JrMTIwMAYDVQQDEylTeW1hbnRlYyBDbGFzcyAzIFNTUCBJbnRlcm1lZGlhdGUgQ0EgLSBHMzAeFw0xNjAxMTkwMDAwMDBaFw0yNDA5MjgyMzU5NTlaMFUxCzAJBgNVBAYTAlVTMRUwEwYDVQQKEwxTdXJlSUQsIEluYy4xFTATBgNVBAsTDFN1cmVJRCBQSVYtSTEYMBYGA1UEAxMPU3VyZUlEIEluYy4gQ0ExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvZLi3n+WCWDKxdmixRmYnvLBpxjyu7VCbyTien7eXkuiKMiYQFn7NMmAX5ZyMy1MqvRg7BHnTvcSnQTgdrfEbX47b/vytHnksrT/vLyQ0Na2y+py6w/gxjirYsdoUdfM0toO3aFS8kqGSGJ63BPMteqwSV93tbUaE/I8knPy7oYxMKCMA+cU0hNlMvpyYW2thXetIzPSgc2/UuwP/irhTA3oguiA/KQ8LRzMNFCnLk3O1tiqxDiIp7WJElRjWqVfItzBIOUpoMpoc8y8kpitNzdSknFSFW0Tpfa0XSnO9hUZmjAryxmIztL9Bw6yJENswxnxN3KkzZ82QixNwZRriwIDAQABo4IB6DCCAeQwEgYDVR0TAQH/BAgwBgEB/wIBADCBgAYDVR0gBHkwdzAPBg1ghkgBhvhFAQcXAwEGMA8GDWCGSAGG+EUBBxcDAQcwDwYNYIZIAYb4RQEHFwMBDTAPBg1ghkgBhvhFAQcXAwEOMA8GDWCGSAGG+EUBBxcDAQ8wDwYNYIZIAYb4RQEHFwMBETAPBg1ghkgBhvhFAQcXAwESMIGJBggrBgEFBQcBAQR9MHswJwYIKwYBBQUHMAGGG2h0dHA6Ly9zc3Atb2NzcC5zeW1hdXRoLmNvbTBQBggrBgEFBQcwAoZEaHR0cDovL3NzcC1haWEuc3ltYXV0aC5jb20vU1ROU1NQL0NlcnRzX2lzc3VlZF90b19DbGFzczNTU1BDQS1HMy5wN2MwRAYDVR0fBD0wOzA5oDegNYYzaHR0cDovL3NzcC1jcmwuc3ltYXV0aC5jb20vU1ROU1NQL0NsYXNzM1NTUENBRzMuY3JsMA4GA1UdDwEB/wQEAwIBBjApBgNVHREEIjAgpB4wHDEaMBgGA1UEAxMRU3ltYW50ZWNQS0ktMi0yOTIwHQYDVR0OBBYEFALCBm2w5wyaemW6pQWUsTNowLSYMB8GA1UdIwQYMBaAFDUmfVCV4aHBvQXVw513QscME5aMMA0GCSqGSIb3DQEBCwUAA4IBAQA1Q6gT34WR/KHhwdXb+lDWRyGJQoIpxD0LiYK1bASBcTYP4rPMYwl8c2030mPLeSZtDP9T8UxMvJ/kYsjCdVj/c6BqS0xximNskYHOW8sUeO8XMQkbnNiIYaxMZ0NaMCjamh7rOUdfVdgg7sW11lQ2qVfsviG8EG+7BmA9etVtpTWznr1aiit4rMwF2dPq94fiKOg7x9gNmo6ev6OtBVXZB/Bayg4nzPlRQk2LMEaNzvDBgPJHueHu/x9E+nMzdgOfDV4JeBPhcLXs2tKAIgGitARvTGtBwe85o1GovSyS2GRP4x67p3co0iod70cyxduISwXgCNyZSTrxqOftRMu7");
		vc.addCertificateTokenForVerification(certificateToken);

		vc.validate();

		Set<CertificateToken> processedCertificates = vc.getProcessedCertificates();
		assertEquals(4, processedCertificates.size()); // cert chain only going up, if it wen't sideways it could get 60+ certs
	}

}
