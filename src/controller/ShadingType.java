package controller;

public enum ShadingType {
    OUTLINE {
        public String toString(){
            return "OUTLINE";
        }
    },
    FILLED_IN {
        public String toString(){
            return "FILLED IN";
        }
    },
    OUTLINE_AND_FILLED_IN {
        public String toString(){
            return "OUTLINE AND FILLED IN";
        }
    }
}
