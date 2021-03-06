/**
 *
 */
package io.github.marcelovca90.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Folders.
 *
 * @author marcelovca90
 */
public class DataSetHelper
{
    public static String SEPARATOR = File.separator;

    public static String BASE_FOLDER = "/Users/marcelocysneiros/Downloads/Vetores-2017-Fev";

    private static String[] dataSets = { "2017_BASE2_LING_SPAM", "2017_BASE2_SPAM_ASSASSIN", "2017_BASE2_TREC", "2017_BASE2_UNIFEI" };

    private static String[] statMethods = { "CHI2", "FD", "MI" };

    private static Integer[] featureAmounts = { 8, 16, 32, 64, 128, 256, 512 };

    public static List<String> getFolders() throws IOException
    {
        File baseFolder = new File(BASE_FOLDER);
        if (!baseFolder.exists() || (baseFolder.exists() && !baseFolder.isDirectory())) throw new IOException();

        List<String> folders = new ArrayList<>();
        for (String dataSet : dataSets)
            for (String statMethod : statMethods)
                for (Integer featureAmount : featureAmounts)
                    folders.add(BASE_FOLDER + SEPARATOR + dataSet + SEPARATOR + statMethod + SEPARATOR + featureAmount);

        return folders;
    }

    public static String getDataSetNameFromFolder(String folder)
    {
        for (String dataSet : dataSets)
        {
            if (folder.contains(dataSet))
            {
                return folder.substring(folder.indexOf(dataSet));
            }
        }
        return folder;
    }
}
