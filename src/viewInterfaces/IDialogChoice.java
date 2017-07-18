package viewInterfaces;

public interface IDialogChoice {
    String getDialogTitle();

    String getDialogText();

    Object[] getDialogOptions();

    Object getDefaultChoice();
}
