var path = require('path');

module.exports = {
    entry: {
        app: "./app.js",
        lobby: "./lobby.js",
        register: "./register.js"
    },
    cache : true,
    output : {
        path : __dirname,
        filename : './build/[name].bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};