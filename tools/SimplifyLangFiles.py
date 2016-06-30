#!/usr/bin/env python

"""
Simplify all the language files to reduce memory use and efficiency
The output files are in "lang/simplified"
"""

import sys
import os

keep = ('tile.', 'item.', 'potion.', 'entity.', 'enchantment.', 'splash_potion.', 'lingering_potion', 'tipped_arrow')

try:
    os.makedirs("lang/simplified", exist_ok=True)
except OSError as err:
    print(err)
    sys.exit(1)

for lang_filename in os.listdir('lang'):
    if not lang_filename.endswith('.lang'):
        continue

    version_file = open("lang/" + lang_filename, 'r', encoding='UTF-8')
    simplified_version_file = open("lang/simplified/" + lang_filename, 'w', encoding='UTF-8')

    for line in version_file:
        if line.startswith(keep) and not (line.startswith('item.') and '.name' not in line):
            simplified_version_file.write(line)
    print("Processed " + lang_filename)
