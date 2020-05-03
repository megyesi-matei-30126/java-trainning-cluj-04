public class Person {
    public static class Builder {
        private String name;
        private String job;
        private String university;
        private boolean drivingLicense;
        private boolean isMaried;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public Builder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public Builder setDrivingLincense(boolean drivingLicense) {
            this.drivingLicense = drivingLicense;
            return this;
        }

        public Builder setIsMaried(boolean isMaried) {
            this.isMaried = isMaried;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    private String name;
    private String job;
    private String university;
    private boolean drivingLicense;
    private boolean isMaried;

    public Person(Builder builder){
        this.name = builder.name;
        this.job = builder.job;
        this.university = builder.university;
        this.drivingLicense = builder.drivingLicense;
        this.isMaried = builder.isMaried;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", university='" + university + '\'' +
                ", drivingLicense=" + drivingLicense +
                ", isMaried=" + isMaried +
                '}';
    }
}
