package arete.java.dev;

import arete.java.request.AreteRequest;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


/**
 * String base in following methods is same as url in AreteClient
 **/
public class SubmissionInitializer {

    SubmissionInitializer(String returnUrl) {
        this.RETURN_URL = returnUrl;
    }

    public SubmissionInitializer() {}

    private final static String UNIID_GIT = "envomp";
    private static final String STUDENT_REPO_PYTHON = "git@gitlab.cs.ttu.ee:envomp/iti0102-2019.git";
    private static final String STUDENT_REPO = "git@gitlab.cs.ttu.ee:envomp/iti0202-2019.git";
    private static final String STUDENT_REPO_EXAM = "git@gitlab.cs.ttu.ee:iti0102-2018/exams/exam2-envomp.git";
    private static final String PROJECT_PYTHON = "iti0102-2019";
    private static final String PROJECT = "iti0202-2019";
    private final static String TESTING_PLATFORM = "java";
    private final static String TESTING_PLATFORM_PYTHON = "python";
    private final static String TESTING_PLATFORM_PROLOG = "prolog";
    private static final String PROJECT_GIT = "git@gitlab.cs.ttu.ee:iti0202-2019/ex.git";
    private static final String PROJECT_GIT_PYTHON = "git@gitlab.cs.ttu.ee:iti0102-2019/ex.git";
    private String RETURN_URL = "https://jsonplaceholder.typicode.com/posts";
    private final static HashSet<String> EXTRA = new HashSet<>(Collections.singletonList("stylecheck"));
    private final static String home = "src/main/java/arete/java/dev/";

    public AreteRequest getFullSubmissionStringControllerEndpoint() {

        return AreteRequest.builder()
                .gitStudentRepo(STUDENT_REPO)
                .hash("2448474b6a76ef534660817948dc8b816e40dd48")
                .testingPlatform(TESTING_PLATFORM)
                .systemExtra((new HashSet<>(Arrays.asList(
                        "noMail"
                ))))
                .returnUrl(RETURN_URL)
                .dockerExtra(EXTRA)
                .build();
    }

    public AreteRequest getFullSubmissionStringControllerEndpointPython() {

        return AreteRequest.builder()
                .gitStudentRepo(STUDENT_REPO_PYTHON)
                .hash("1bf2d711ce9ff944c7c9ffd9def23d312e9c4f9f")
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .systemExtra((new HashSet<>(Arrays.asList(
                        "noMail"
                ))))
                .returnUrl(RETURN_URL)
                .dockerExtra(EXTRA)
                .build();
    }

    public AreteRequest getFullSubmissionStringControllerEndpointPythonLong() {

        return AreteRequest.builder()
                .gitStudentRepo(STUDENT_REPO_PYTHON)
                .hash("a932ed61340fbaa08e308f591d5b5791044abc0c")
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .systemExtra((new HashSet<>(Arrays.asList(
////						, "noMail"
                ))))
                .returnUrl(RETURN_URL)
                .dockerExtra(EXTRA)
                .dockerTimeout(10)
                .build();
    }

    public AreteRequest getFullSubmissionStringControllerEndpointPythonRecursion() {

        return AreteRequest.builder()
                .gitStudentRepo("https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git")
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .systemExtra((new HashSet<>(Arrays.asList(
//						, "noMail"
                ))))
                .returnUrl(RETURN_URL)
                .dockerExtra(EXTRA)
                .priority(10)
                .build();
    }

    public AreteRequest getFullSubmissionStringControllerEndpointPythonCustomConfiguration() {

        return AreteRequest.builder()
                .gitStudentRepo("https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git")
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .returnUrl(RETURN_URL)
                .priority(10)
                .build();
    }

    public AreteRequest getFullSubmissionStringExamControllerEndpoint() {

        return AreteRequest.builder()
                .gitStudentRepo(STUDENT_REPO_EXAM)
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .systemExtra((new HashSet<>(Arrays.asList("noStd", "noFeedback", "noMail"))))
                .uniid("envomp")
                .returnUrl(RETURN_URL)
                .dockerExtra(EXTRA)
                .build();
    }

    public AreteRequest getFullSubmissionStringProlog() {

        return AreteRequest.builder()
                .gitStudentRepo("https://gitlab.cs.ttu.ee/envomp/iti0211-2019.git")
                .testingPlatform(TESTING_PLATFORM_PROLOG)
                .uniid("envomp")
                .returnUrl(RETURN_URL)
                .build();
    }

    public AreteRequest getFullSubmissionStringSync(String base) throws IOException {
        String hash = getRandomHash();

        return AreteRequest.builder()
                .testingPlatform(TESTING_PLATFORM)
                .hash(hash)
                .returnUrl(String.format("%s/waitingroom/%s", base, hash))
                .gitTestSource(PROJECT_GIT)
                .systemExtra((new HashSet<>(Arrays.asList(
////						, "noMail"
                ))))
                .source(new ArrayList<>(Collections.singletonList(
                        AreteRequest.SourceFile.builder()
                                .path("EX01IdCode/src/ee/taltech/iti0202/idcode/IDCode.java")
                                .contents(JAVA_CODE)
                                .build())))
                .build();
    }


    public AreteRequest getFullSubmissionStringPythonSync(String base) throws IOException {

        String hash = getRandomHash();

        return AreteRequest.builder()
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .dockerExtra(EXTRA)
                .hash(hash)
                .systemExtra((new HashSet<>(Arrays.asList(
////						, "noMail"
                ))))
                .returnUrl(String.format("%s/waitingroom/%s", base, hash))
                .gitTestSource(PROJECT_GIT_PYTHON)
                .source(new ArrayList<>(Collections.singletonList(
                        AreteRequest.SourceFile.builder()
                                .path("ex04_cipher/cipher.py")
                                .contents(PYTHON_CODE)
                                .build())))
                .build();
    }

    public AreteRequest getFullSubmissionStringPythonSyncNoStyle(String base) throws IOException {

        String hash = getRandomHash();

        return AreteRequest.builder()
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .dockerExtra(new HashSet<>())
                .hash(hash)
                .systemExtra((new HashSet<>(Arrays.asList(
////						, "noMail"
                ))))
                .returnUrl(String.format("%s/waitingroom/%s", base, hash))
                .gitTestSource(PROJECT_GIT_PYTHON)
                .source(new ArrayList<>(Collections.singletonList(
                        AreteRequest.SourceFile.builder()
                                .path("ex04_cipher/cipher.py")
                                .contents(PYTHON_CODE)
                                .build())))
                .build();
    }


    public AreteRequest getFullSubmissionStringPythonSyncNoStdout(String base) throws IOException {

        String hash = getRandomHash();

        return AreteRequest.builder()
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .dockerExtra(EXTRA)
                .systemExtra(new HashSet<>(Arrays.asList("noStd"
//						, "noMail"
                )))
                .hash(hash)
                .returnUrl(String.format("%s/waitingroom/%s", base, hash))
                .gitTestSource(PROJECT_GIT_PYTHON)
                .source(new ArrayList<>(Collections.singletonList(
                        AreteRequest.SourceFile.builder()
                                .path("ex04_cipher/cipher.py")
                                .contents(PYTHON_CODE)
                                .build())))
                .build();
    }

    public AreteRequest getFullSubmissionStringPythonSyncNoTesterFiles(String base) throws IOException {

        String hash = getRandomHash();

        return AreteRequest.builder()
                .testingPlatform(TESTING_PLATFORM_PYTHON)
                .dockerExtra(EXTRA)
                .systemExtra(new HashSet<>(Arrays.asList("noTesterFiles"
//						, "noMail"
                )))
                .hash(hash)
                .returnUrl(String.format("%s/waitingroom/%s", base, hash))
                .gitTestSource(PROJECT_GIT_PYTHON)
                .source(new ArrayList<>(Collections.singletonList(
                        AreteRequest.SourceFile.builder()
                                .path("ex04_cipher/cipher.py")
                                .contents(PYTHON_CODE)
                                .build())))
                .build();
    }

    private static String getRandomHash() {
        return RandomStringUtils.random(64, true, true).toLowerCase();
    }


    private static final String JAVA_CODE = "package ee.taltech.iti0202.idcode;\n" +
            "\n" +
            "public class IDCode {\n" +
            "\n" +
            "\tpublic static final int ZERO = 0;\n" +
            "\tprivate static final int YEAR_LOCATION = 3;\n" +
            "\tprivate static final int MONTH_LOCATION = 5;\n" +
            "\tprivate static final int DAY_LOCATION = 7;\n" +
            "\tprivate static final int ID_CODE_LENGTH = 11;\n" +
            "\tprivate static final int MONTHS_IN_A_YEAR = 12;\n" +
            "\tprivate static final int LEAP_FEB = 29;\n" +
            "\tprivate static final int NO_LEAP_FEB = 28;\n" +
            "\tprivate static final int DAYS_IN_JAN = 31;\n" +
            "\tprivate static final int DAYS_IN_APRIL = 30;\n" +
            "\tprivate static final int[] MULTIPLIERS1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};\n" +
            "\tprivate static final int[] MULTIPLIERS2 = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};\n" +
            "\tprivate static final int LEAP_MAX = 400;\n" +
            "\tprivate static final int YEAR_MAX = 99;\n" +
            "\tprivate static final int QUEUE_MAX = 999;\n" +
            "\tprivate static final int EPOCH_YEAR = 1700;\n" +
            "\n" +
            "\tpublic static boolean isIDCodeCorrect(String idCode) {\n" +
            "\n" +
            "\t\treturn idCode.length() == ID_CODE_LENGTH && idCode.matches(\"[0-9]+\")\n" +
            "\t\t\t\t&& isGenderNumberCorrect(idCode) && isYearNumberCorrect(idCode)\n" +
            "\t\t\t\t&& isMonthNumberCorrect(idCode) && isDayNumberCorrect(idCode)\n" +
            "\t\t\t\t&& isQueueNumberCorrect(idCode) && isControlNumberCorrect(idCode);\n" +
            "\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isGenderNumberCorrect(String idCode) {\n" +
            "\t\treturn idCode.substring(0, 1).matches(\"^[1-6]$\");\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isYearNumberCorrect(String idCode) {\n" +
            "\t\tint year = Integer.parseInt(idCode.substring(YEAR_LOCATION - 2, YEAR_LOCATION));\n" +
            "\t\treturn year >= 0 && year <= YEAR_MAX;\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isMonthNumberCorrect(String idCode) {\n" +
            "\t\tint month = Integer.parseInt(idCode.substring(YEAR_LOCATION, MONTH_LOCATION));\n" +
            "\t\treturn month > 0 && month <= MONTHS_IN_A_YEAR;\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isDayNumberCorrect(String idCode) {\n" +
            "\t\tint year = getFullYear(idCode);\n" +
            "\t\tboolean leap = isLeapYear(year);\n" +
            "\t\tString month = idCode.substring(YEAR_LOCATION, MONTH_LOCATION);\n" +
            "\t\tint day = Integer.parseInt(idCode.substring(MONTH_LOCATION, DAY_LOCATION));\n" +
            "\t\tif (Integer.parseInt(month) == 2) {\n" +
            "\t\t\tif (leap) {\n" +
            "\t\t\t\treturn day > 0 && day <= LEAP_FEB;\n" +
            "\t\t\t} else {\n" +
            "\t\t\t\treturn day > ZERO && day <= NO_LEAP_FEB;\n" +
            "\t\t\t}\n" +
            "\t\t} else if (month.equals(\"04\") || month.equals(\"06\") || month.equals(\"09\") || month.equals(\"11\")) {\n" +
            "\t\t\treturn day > 0 && day <= DAYS_IN_APRIL;\n" +
            "\t\t} else {\n" +
            "\t\t\treturn day > 0 && day <= DAYS_IN_JAN;\n" +
            "\t\t}\n" +
            "\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isQueueNumberCorrect(String idCode) {\n" +
            "\t\tint queue = Integer.parseInt(idCode.substring(DAY_LOCATION, 10));\n" +
            "\t\treturn queue > 0 && queue <= QUEUE_MAX;\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isControlNumberCorrect(String idCode) {\n" +
            "\t\tint controlNumber = 0;\n" +
            "\t\tfor (int i = 0; i < 10; i++) {\n" +
            "\t\t\tcontrolNumber += MULTIPLIERS1[i] * Character.getNumericValue(idCode.charAt(i));\n" +
            "\t\t}\n" +
            "\t\tcontrolNumber %= ID_CODE_LENGTH;\n" +
            "\t\tif (controlNumber == 10) {\n" +
            "\t\t\tcontrolNumber = 0;\n" +
            "\t\t\tfor (int i = 0; i < 10; i++) {\n" +
            "\t\t\t\tcontrolNumber += MULTIPLIERS2[i] * Character.getNumericValue(idCode.charAt(i));\n" +
            "\t\t\t}\n" +
            "\t\t\tcontrolNumber %= ID_CODE_LENGTH;\n" +
            "\t\t\tif (controlNumber == 10) {\n" +
            "\t\t\t\tcontrolNumber = 0;\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\n" +
            "\t\treturn controlNumber == Integer.parseInt(idCode.substring(10));\n" +
            "\t}\n" +
            "\n" +
            "\tprivate static boolean isLeapYear(int fullYear) {\n" +
            "\t\tif (fullYear % LEAP_MAX == 0) {\n" +
            "\t\t\treturn true;\n" +
            "\t\t} else if (fullYear % 100 == 0) {\n" +
            "\t\t\treturn false;\n" +
            "\t\t}\n" +
            "\t\treturn fullYear % 4 == 0;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic static String getInformationFromIDCode(String idCode) {\n" +
            "\t\tif (!isIDCodeCorrect(idCode)) {\n" +
            "\t\t\treturn \"Given invalid ID code!\";\n" +
            "\t\t}\n" +
            "\t\treturn \"This is a \" + getGender(idCode).toString().toLowerCase() + \" born on \"\n" +
            "\t\t\t\t+ idCode.substring(5, DAY_LOCATION) + \".\" + idCode.substring(3, 5) + \".\" + getFullYear(idCode);\n" +
            "\t}\n" +
            "\n" +
            "\tpublic static Gender getGender(String idCode) {\n" +
            "\t\tString genderNumber = idCode.substring(0, 1);\n" +
            "\t\tif (genderNumber.matches(\"^[1|3|5]$\")) {\n" +
            "\t\t\treturn Gender.MALE;\n" +
            "\t\t}\n" +
            "\t\treturn Gender.FEMALE;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic static int getFullYear(String idCode) {\n" +
            "\t\treturn Integer.parseInt(idCode.substring(1, 3)) + EPOCH_YEAR\n" +
            "\t\t\t\t+ ((Integer.parseInt(idCode.substring(0, 1)) + 1) / 2) * 100;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic static void main(String[] args) {\n" +
            "\n" +
            "\t}\n" +
            "\n" +
            "\tprivate enum Gender {\n" +
            "\t\tMALE, FEMALE\n" +
            "\t}\n" +
            "}\n";

    private static final String PYTHON_CODE = "from itertools import cycle\n" +
            "\n" +
            "\n" +
            "def rail_pattern(n):\n" +
            "    r = list(range(n))\n" +
            "    return cycle(r + r[-2: 0: - 1])\n" +
            "\n" +
            "\n" +
            "def encode(a, b):\n" +
            "    p = rail_pattern(b)\n" +
            "    # this relies on key being called in order, guaranteed?\n" +
            "    return ''.join(sorted(a, key=lambda i: next(p))).replace(\" \", \"_\")\n" +
            "\n" +
            "\n" +
            "def decode(a, b):\n" +
            "    p = rail_pattern(b)\n" +
            "    indexes = sorted(range(len(a)), key=lambda i: next(p))\n" +
            "    result = [''] * len(a)\n" +
            "    for i, c in zip(indexes, a):\n" +
            "        result[i] = c\n" +
            "    return ''.join(result).replace(\"_\", \"_\")\n" +
            "\n" +
            "\n" +
            "print(encode(\"Mind on vaja krüpteerida\", 3))  # => M_v_prido_aaküteiannjred\n" +
            "print(encode(\"Mind on\", 3))  # => M_idonn\n" +
            "print(encode(\"hello\", 1))  # => hello\n" +
            "print(encode(\"hello\", 8))  # => hello\n" +
            "print(encode(\"kaks pead\", 1))  # => kaks_pead\n" +
            "\n" +
            "print(decode(\"kaks_pead\", 1))  # => kaks pead\n" +
            "print(decode(\"M_idonn\", 3))  # => Mind on\n" +
            "print(decode(\"M_v_prido_aaküteiannjred\", 3))  # => Mind on vaja krüpteerida\n";
}
