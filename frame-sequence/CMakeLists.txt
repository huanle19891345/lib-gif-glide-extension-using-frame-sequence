cmake_minimum_required(VERSION 3.4.1)

file(GLOB framesequence_source src/main/cpp/*.cpp)
file(GLOB giflib_source src/main/cpp/giflib/*.c)

include_directories(src/main/cpp/giflib)

add_library( # Sets the name of the library.
             framesequence

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             ${framesequence_source}
              ${giflib_source})

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( # Specifies the target library.
                       framesequence

                       # Links the target library to the log library
                       # included in the NDK.
                       jnigraphics
                       log )