Tools
=================

Language files are **not** licensed under LangUtils. They are owned by Mojang.

If you want to use the code of these tools, feel free to decompile and use  them without restrictions.(Though the code is messy and bad)

hexosse wrote his own version of these tools, check it out: https://github.com/hexosse/LanguageUtilsTools


## Export Lang files

Copy `ExportLangFiles.py` to `.minecraft\assets` folder and run it with Python 3.4+. Enter the version name of indexes file. It will generate a `lang/` folder with all the lang files in it.

## Simplify Lang Files

Modify the lang files(Reduce useless parts) to achieve higher efficiency. Just run it in this folder. You will find simplified language files in `lang/simplified/`.

## Generate Lang Code

Generate code for `EnumLang` class. Run it in this folder, and it will generate a output file.

## Generate Items Code

Generate code for `EnumLang` class. Run it in this folder, and it will generate a output file. Still need to fill in `Material` data.