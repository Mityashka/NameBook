import java.time.LocalDate;
class UserData {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final LocalDate dateOfBirth;
    private final long phoneNumber;
    private final String gender;

    public UserData(String lastName, String firstName, String middleName, String dateOfBirth, long phoneNumber, String gender) throws InvalidDataFormatException {
        if (lastName == null || firstName == null || middleName == null || dateOfBirth == null || gender == null) {
            throw new InvalidDataFormatException("Пропущены одно или несколько полей");
        }

        if (dateOfBirth.length() != 10 || dateOfBirth.charAt(2) != '.' || dateOfBirth.charAt(5) != '.') {
            throw new InvalidDataFormatException("Неверный формат даты. используйте dd.mm.yyyy");
        }

        try {
            String[] dateArray = dateOfBirth.split("\\.");
            int day = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);
            this.dateOfBirth = LocalDate.of(year, month, day);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            throw new InvalidDataFormatException("Неверный формат даты. используйте dd.mm.yyyy");
        }

        if (phoneNumber < 0) {
            throw new InvalidDataFormatException("Неверный номер");
        }

        if (!gender.equals("f") && !gender.equals("m")) {
            throw new InvalidDataFormatException("Неверное значение. Используйте 'f' или 'm'");
        }

        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }
}