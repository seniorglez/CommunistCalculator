# CommunistCalculator

A meme calculator that actually partially works

![A funny picture](https://i.imgur.com/P8gNpGs.png)
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

#### Android Studio

##### MacOS/Windows

Just Download it from the official [website](https://developer.android.com/studio/).

#### Arch Linux

I had some problems trying to install this with yay so I will show you how to build and install this package by yourself.
First and foremost lets clone the repo.
```bash
    git clone https://aur.archlinux.org/android-studio.git

```

Now we are going to build the package.

```bash
    cd android-studio/
    makepkg -s
```

Using pacman we can install now owr package. (version number may had change)

```bash

    sudo pacman -U --noconfirm android-studio-3.5.3.0-1-x86_64.pkg.tar.xz

```

And we are done. Now try to run Android Studio now from the term!

```bash
    android-studio

``` 

## Built With

* [AndroidStudio](https://developer.android.com/studio/) - The IDE I used

## Contributing

Feel free to fork it and made pull request.

## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

CommunistCalculator is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.


CommunistCalculator is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the [GNU General Public License](LICENSE)
along with CommunistCalculator. If not, see [https://www.gnu.org/licenses/](https://www.gnu.org/licenses/)

![GPL3 or later](https://www.gnu.org/graphics/gplv3-or-later.png)
