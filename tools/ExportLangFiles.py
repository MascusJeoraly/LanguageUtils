#!/usr/bin/env python

"""
Export all the language files in Minecraft
Please copy this program to ".minecraft/assets/" directory and use Python 3.4+ to run this program.
"""

import os
import sys
import shutil

version_filename = input("Version: ") + ".json"

try:
    version_file = open("indexes/" + version_filename, 'r', encoding='UTF-8')
except FileNotFoundError as err:
    print(err)
    sys.exit(1)

try:
    os.makedirs("lang", exist_ok=True)
except OSError as err:
    print(err)
    sys.exit(1)

for line in version_file:
    if line.__contains__("minecraft/lang/"):
        lang_name = line.replace("minecraft/lang/", "").replace("\"", "").replace(":", "").replace("{", "").strip()
        lang_hash = next(version_file).replace("hash", "").replace(",", "").replace(":", "").replace("\"", "").strip()
        try:
            shutil.copyfile("objects/" + lang_hash[:2] + "/" + lang_hash, "lang/" + lang_name)
            print("Copied " + lang_name + " from " + lang_hash[:2] + "/" + lang_hash)
        except OSError as err:
            print(lang_name + ":")
            print(err)
