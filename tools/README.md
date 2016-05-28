Tools
=================

Lang files are **not** a part of the project.

If you want to use the code of these tools, feel free to decompile and use  them without restrictions.(Though the code is messy and bad)

hexosse wrote his own version of these tools, check it out: https://github.com/hexosse/LanguageUtilsTools


## Export Lang files

Copy `ExportLangFiles.jar` to `.minecraft\assets` folder and run the program. It will generate a `output/` folder with lang files in it.

## Simplify Lang Files

Modify the lang files(Reduce useless parts) to achieve higher efficiency. Just run it in this folder. Generated files will locate at `lang/modified/`. If you want to just export Item names, add argument, `onlyItems`.

## Generate Lang Code

Generate code for `EnumLang` class. Run it in this folder, and it will generate a output file.

## Generate Items Code

Generate code for `EnumLang` class. Run it in this folder, and it will generate a output file. Still need to fill in `Material` data.